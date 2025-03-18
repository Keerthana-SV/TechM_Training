import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';
import '../services/sos_service.dart';

class SOSScreen extends StatefulWidget {
  const SOSScreen({super.key});

  @override
  _SOSScreenState createState() => _SOSScreenState();
}

class _SOSScreenState extends State<SOSScreen> {
  final SOSService sosService = SOSService();

  // Emergency contacts list
  final List<String> emergencyContacts = [
    "+917845689470",
    "+919444463725",
    "+919444515089"
  ];

  // Trigger SOS
  void triggerSOS() async {
  for (String contact in emergencyContacts) {
    await sosService.sendEmergencySMS(
      contact,
     "⚠️ Emergency! I need help. Please track my location immediately!",
    );
  }
    if (!mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      const SnackBar(content: Text("SOS SMS sent to emergency contacts!")),
    );
  }

  // Call emergency number
  void makeCall(String number) async {
    final Uri launchUri = Uri(scheme: 'tel', path: number);
    if (await canLaunchUrl(launchUri)) {
      await launchUrl(launchUri);
    } else {
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text("Could not launch dialer.")),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: const Text("SOS Alert"),
        centerTitle: true,
        backgroundColor: Colors.redAccent,
        elevation: 5,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Icon(
              Icons.warning,
              color: Colors.redAccent,
              size: 100,
            ),
            const SizedBox(height: 20),
            const Text(
              "Emergency SOS",
              style: TextStyle(
                fontSize: 26,
                fontWeight: FontWeight.bold,
                color: Colors.redAccent,
              ),
            ),
            const SizedBox(height: 10),
            Text(
              "Tap below to send SOS alert",
              style: TextStyle(fontSize: 16, color: Colors.grey[700]),
            ),
            const SizedBox(height: 30),
            ElevatedButton.icon(
              onPressed: triggerSOS,
              icon: const Icon(Icons.send),
              label: const Text(
                "Send SOS",
                style: TextStyle(fontSize: 20),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.redAccent,
                padding: const EdgeInsets.symmetric(horizontal: 50, vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(30),
                ),
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton.icon(
              onPressed: () => makeCall(emergencyContacts.first),
              icon: const Icon(Icons.call),
              label: const Text(
                "Call Emergency Contact",
                style: TextStyle(fontSize: 18),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.green,
                padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(30),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
