import 'movie.dart';

class Booking {
  final Movie movie;
  final DateTime dateTime;
  final String seat;
  final double price;

  Booking({
    required this.movie,
    required this.dateTime,
    required this.seat,
    required this.price,
  });

  factory Booking.fromJson(Map<String, dynamic> json) {
    return Booking(
      movie: Movie.fromJson(json['movie']),
      dateTime: DateTime.parse(json['dateTime']),
      seat: json['seat'] ?? 'N/A',
      price: (json['price'] as num?)?.toDouble() ?? 0.0,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'movie': movie, // May need to manually map this if using Firestore
      'dateTime': dateTime.toIso8601String(),
      'seat': seat,
      'price': price,
    };
  }
}
