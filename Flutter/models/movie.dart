class Movie {
  final String title;
  final String poster;
  final String year;
  final String imdbID;
  final String type;
  final double ticketPrice;
  final String? rating;

  const Movie({
    required this.title,
    required this.poster,
    required this.year,
    required this.imdbID,
    required this.type,
    required this.ticketPrice,
    this.rating,
  });

  factory Movie.fromJson(Map<String, dynamic> json) {
    return Movie(
      title: json['Title']?.toString() ?? 'Untitled',
      poster: _parsePosterUrl(json['Poster']),
      year: json['Year']?.toString() ?? 'Year unknown',
      imdbID: json['imdbID']?.toString() ?? '',
      type: json['Type']?.toString().toUpperCase() ?? 'MOVIE',
      ticketPrice: (json['TicketPrice'] as num?)?.toDouble() ?? 12.99,
      rating: json['imdbRating']?.toString(),
    );
  }

  static String _parsePosterUrl(dynamic posterUrl) {
    if (posterUrl == null || 
        posterUrl.toString().isEmpty || 
        posterUrl.toString().toLowerCase() == 'n/a') {
      return 'https://via.placeholder.com/150/424242/FFFFFF?text=No+Image';
    }
    return posterUrl.toString();
  }
}