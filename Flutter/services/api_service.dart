import 'dart:convert';
import 'dart:math';
import 'package:http/http.dart' as http;
import '../models/movie.dart';

class ApiService {
  static const String _baseUrl = "www.omdbapi.com";
  static const String _apiKey = "38c21b48";
  static final Random _random = Random();

  static Future<List<Movie>> fetchMovies({
    required String query,
    required int page,
  }) async {
    try {
      final uri = Uri.https(_baseUrl, '', {
        'apikey': _apiKey,
        's': query,
        'page': page.toString(),
        'type': 'movie',
      });

      final response = await http.get(uri);
      
      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        if (data["Response"] == "True") {
          List<dynamic> results = data['Search'];
          return results.map((json) {
            return Movie.fromJson({
              ...json,
              'TicketPrice': 8.99 + _random.nextDouble() * 16,
            });
          }).toList();
        }
      }
      return [];
    } catch (e) {
      throw Exception("Failed to fetch movies: ${e.toString()}");
    }
  }
}