import 'package:flutter/material.dart';
import '../services/api_service.dart';
import '../models/movie.dart';
import 'booking_screen.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Movie> movies = [];
  bool isLoading = false;
  String searchQuery = "batman";  // Default search

  @override
  void initState() {
    super.initState();
    fetchMovies(searchQuery);
  }

  Future<void> fetchMovies(String query) async {
    setState(() => isLoading = true);
    try {
      List<Movie> fetchedMovies = await ApiService.fetchMovies(query);
      setState(() {
        movies = fetchedMovies;
        isLoading = false;
      });
    } catch (e) {
      setState(() {
        movies = [];
        isLoading = false;
      });
      print("Error: $e");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("CineVerse")),
      body: Column(
        children: [
          Padding(
            padding: EdgeInsets.all(10),
            child: TextField(
              decoration: InputDecoration(
                hintText: "Search movies...",
                border: OutlineInputBorder(),
                suffixIcon: Icon(Icons.search),
              ),
              onSubmitted: (query) => fetchMovies(query),
            ),
          ),
          Expanded(
            child: isLoading
                ? Center(child: CircularProgressIndicator())
                : movies.isEmpty
                    ? Center(child: Text("No movies found"))
                    : ListView.builder(
                        itemCount: movies.length,
                        itemBuilder: (context, index) {
                          return ListTile(
                            leading: Image.network(movies[index].poster, width: 50, height: 70, fit: BoxFit.cover),
                            title: Text(movies[index].title),
                            subtitle: Text("Year: ${movies[index].year}"),
                            trailing: ElevatedButton(
                              onPressed: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) => BookingScreen(movie: movies[index]),
                                  ),
                                );
                              },
                              child: Text("Book Now"),
                            ),
                          );
                        },
                      ),
          ),
        ],
      ),
    );
  }
}
