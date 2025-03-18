import 'package:location/location.dart';

class LocationService {
  final Location location = Location();

  Future<LocationData?> getCurrentLocation() async {
    try {
      return await location.getLocation();
    } catch (e) {
      print("Error: $e");
      return null;
    }
  }
}
