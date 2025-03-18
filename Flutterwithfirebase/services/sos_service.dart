import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:telephony/telephony.dart';
import 'package:location/location.dart';

class SOSService {
  final Telephony telephony = Telephony.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  Future<void> sendEmergencySMS(String contact, String s) async {
    // Fetch emergency contacts from Firestore
    QuerySnapshot snapshot = await _firestore.collection('emergency_contacts').get();
    List<String> contacts = snapshot.docs.map((doc) => doc['phone'] as String).toList();

    if (contacts.isEmpty) return;

    // Get current location
    Location location = Location();
    LocationData currentLocation = await location.getLocation();

    String message = "⚠️ Emergency! I need help. My location: "
        "https://www.google.com/maps/search/?api=1&query=${currentLocation.latitude},${currentLocation.longitude}";

    // Send SMS to each contact
    for (String phone in contacts) {
      await telephony.sendSms(
        to: phone,
        message: message,
      );
    }
  }
}
