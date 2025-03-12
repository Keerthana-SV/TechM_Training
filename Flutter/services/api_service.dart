import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/movie.dart';

class ApiService {
  static const String _baseUrl = "http://www.omdbapi.com/";
  static const String _apiKey = "38c21b48";  // Use your own API key

  static Future<List<Movie>> fetchMovies(String query) async {
    final response = await http.get(Uri.parse("$_baseUrl/?apikey=$_apiKey&s=$query"));

    print("Response Code: ${response.statusCode}");
    print("Response Body: ${response.body}");

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      if (data["Response"] == "True") {
        List<dynamic> results = data['Search'];
        return results.map((json) => Movie.fromJson(json)).toList();
      } else {
        throw Exception(data["Error"] ?? "Failed to load movies");
      }
    } else {
      throw Exception("Failed to load movies");
    }
  }
}
