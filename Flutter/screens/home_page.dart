import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:my_app/screens/booking_page.dart';
import '../../core/theme/theme_provider.dart';
import '/models/movie.dart';
import '/services/api_service.dart';
import 'dart:async';
import '/screens/TicketsPage.dart'; // Adjust path as needed


class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final TextEditingController _searchController = TextEditingController();
  final FocusNode _searchFocusNode = FocusNode();
  final _scrollController = ScrollController();
  final _debounceDuration = const Duration(milliseconds: 500);
  Timer? _debounce;

  List<Movie> _movies = [];
  List<Movie> _filteredMovies = [];
  bool _isLoading = false;
  bool _isError = false;
  String _searchQuery = "";
  int _currentPage = 1;
  bool _hasMore = true;

  @override
  void initState() {
    super.initState();
    _searchController.addListener(_onSearchChanged);
    _scrollController.addListener(_onScroll);
    _fetchMovies();
  }

  @override
  void dispose() {
    _searchController.dispose();
    _searchFocusNode.dispose();
    _scrollController.dispose();
    _debounce?.cancel();
    super.dispose();
  }

  void _onSearchChanged() {
    if (_debounce?.isActive ?? false) _debounce?.cancel();
    _debounce = Timer(_debounceDuration, () {
      setState(() {
        _searchQuery = _searchController.text.trim().toLowerCase();
        _filterMovies();
      });
    });
  }

  void _filterMovies() {
    if (_searchQuery.isEmpty) {
      _filteredMovies = _movies;
    } else {
      _filteredMovies = _movies.where((movie) {
        return movie.title.toLowerCase().contains(_searchQuery);
      }).toList();
    }
  }

  Future<void> _fetchMovies() async {
    if (!_hasMore || _isLoading) return;

    setState(() {
      _isLoading = true;
      _isError = false;
    });

    try {
      final newMovies = await ApiService.fetchMovies(
        query: _searchQuery.isNotEmpty ? _searchQuery : "batman",
        page: _currentPage,
      );

      setState(() {
        _isLoading = false;
        final newIds = newMovies.map((m) => m.imdbID).toSet();
        _movies = [
          ..._movies.where((m) => !newIds.contains(m.imdbID)),
          ...newMovies,
        ];
        _filterMovies();
        _hasMore = newMovies.isNotEmpty;
        _currentPage++;
      });
    } catch (e) {
      setState(() {
        _isLoading = false;
        _isError = true;
      });
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text("Error loading movies: ${e.toString()}"),
          backgroundColor: Colors.red,
        ),
      );
    }
  }

  void _onScroll() {
    final maxScroll = _scrollController.position.maxScrollExtent;
    final currentScroll = _scrollController.position.pixels;
    if (currentScroll >= maxScroll * 0.9) {
      _fetchMovies();
    }
  }

Widget _buildMovieCard(Movie movie) {
  return Card(
    margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
    elevation: 4,
    child: InkWell(
      borderRadius: BorderRadius.circular(15),
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (_) => BookingScreen(movie: movie)),
        );
      },
        child: Row(
          children: [
            ClipRRect(
              borderRadius: const BorderRadius.horizontal(left: Radius.circular(15)),
              child: Image.network(
                movie.poster,
                width: 100,
                height: 130,
                fit: BoxFit.cover,
                loadingBuilder: (_, child, progress) =>
                    progress == null ? child : const _LoadingIndicator(),
                errorBuilder: (_, __, ___) => const _ErrorPlaceholder(),
              ),
            ),
            Expanded(
              child: Padding(
                padding: const EdgeInsets.all(12),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      movie.title,
                      style: Theme.of(context).textTheme.titleMedium?.copyWith(
                            fontWeight: FontWeight.bold,
                          ),
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    const SizedBox(height: 8),
                    Text(
                      "Year: ${movie.year}",
                      style: Theme.of(context).textTheme.bodyMedium,
                    ),
                    if (movie.rating != null)
                      Padding(
                        padding: const EdgeInsets.only(top: 4),
                        child: Row(
                          children: [
                            const Icon(Icons.star, size: 16, color: Colors.amber),
                            const SizedBox(width: 4),
                            Text(
                              movie.rating!,
                              style: Theme.of(context).textTheme.bodySmall,
                            ),
                          ],
                        ),
                      ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildSearchField() {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
      child: TextField(
        controller: _searchController,
        focusNode: _searchFocusNode,
        decoration: InputDecoration(
          hintText: "Search movies...",
          prefixIcon: const Icon(Icons.search),
          suffixIcon: IconButton(
            icon: const Icon(Icons.clear),
            onPressed: () {
              _searchController.clear();
              _searchFocusNode.unfocus();
              setState(() => _searchQuery = "");
            },
          ),
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(12),
            borderSide: BorderSide.none,
          ),
          filled: true,
          fillColor: Theme.of(context).colorScheme.surfaceVariant,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final themeProvider = Provider.of<ThemeProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Cineverse",
          style: TextStyle(
            fontSize: 28,
            fontWeight: FontWeight.bold,
            color: Theme.of(context).colorScheme.primary,
          ),
        ),
        centerTitle: true,
        actions: [
          IconButton(
            icon: const Icon(Icons.confirmation_number_outlined), // 🎟️ Ticket Icon
            tooltip: 'My Tickets',
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (_) => const TicketsPage()),
              );
            },
          ),
          Padding(
            padding: const EdgeInsets.only(right: 16),
            child: Switch(
              value: themeProvider.isDarkMode,
              onChanged: themeProvider.toggleTheme,
            ),
          ),
        ],
      ),
      body: Column(
        children: [
          _buildSearchField(),
          Expanded(
            child: _isError
                ? _ErrorState(onRetry: _fetchMovies)
                : _filteredMovies.isEmpty
                    ? _EmptyState(searchQuery: _searchQuery)
                    : ListView.builder(
                        controller: _scrollController,
                        itemCount: _filteredMovies.length + (_hasMore ? 1 : 0),
                        itemBuilder: (context, index) {
                          if (index >= _filteredMovies.length) {
                            return const _LoadingIndicator();
                          }
                          return _buildMovieCard(_filteredMovies[index]);
                        },
                      ),
          ),
        ],
      ),
    );
  }
}

class _LoadingIndicator extends StatelessWidget {
  const _LoadingIndicator();

  @override
  Widget build(BuildContext context) {
    return const Padding(
      padding: EdgeInsets.all(24),
      child: Center(child: CircularProgressIndicator()),
    );
  }
}

class _ErrorPlaceholder extends StatelessWidget {
  const _ErrorPlaceholder();

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 100,
      height: 130,
      color: Colors.grey[200],
      child: const Icon(Icons.broken_image, size: 40),
    );
  }
}

class _ErrorState extends StatelessWidget {
  final VoidCallback onRetry;

  const _ErrorState({required this.onRetry});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Icon(Icons.error_outline, size: 48, color: Colors.red),
          const SizedBox(height: 16),
          const Text("Failed to load movies"),
          const SizedBox(height: 16),
          ElevatedButton(
            onPressed: onRetry,
            child: const Text("Retry"),
          ),
        ],
      ),
    );
  }
}

class _EmptyState extends StatelessWidget {
  final String searchQuery;

  const _EmptyState({required this.searchQuery});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(Icons.movie_filter, size: 64, color: Colors.grey[400]),
          const SizedBox(height: 16),
          Text(
            searchQuery.isEmpty
                ? "Start searching for movies!"
                : "No results for '$searchQuery'",
            style: Theme.of(context).textTheme.titleMedium,
          ),
        ],
      ),
    );
  }
}
