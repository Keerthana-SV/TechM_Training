class Movie {
  final String title;
  final String poster;
  final String year;

  Movie({required this.title, required this.poster, required this.year});

  factory Movie.fromJson(Map<String, dynamic> json) {
    return Movie(
      title: json['Title'] ?? "No Title",
      poster: json['Poster'] ?? "https://via.placeholder.com/150",
      year: json['Year'] ?? "Unknown",
    );
  }
}
