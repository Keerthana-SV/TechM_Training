import 'package:cloud_firestore/cloud_firestore.dart';
import '/models/booking.dart';
import 'package:flutter/foundation.dart';

class FirestoreService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

  Future<List<Booking>> getUserBookings() async {
    try {
      final querySnapshot = await _db.collection('bookings').get();

      final bookings = querySnapshot.docs.map((doc) {
        try {
          return Booking.fromJson(doc.data());
        } catch (e) {
          debugPrint("Failed to parse booking: $e");
          return null;
        }
      }).whereType<Booking>().toList();

      return bookings;
    } catch (e) {
      throw Exception("Failed to load bookings: $e");
    }
  }
}
