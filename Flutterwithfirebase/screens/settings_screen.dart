import 'package:flutter/material.dart';

class SettingsScreen extends StatelessWidget {
  const SettingsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Settings"),
        backgroundColor: Colors.deepPurple,
      ),
      body: ListView(
        padding: EdgeInsets.all(16),
        children: [
          ListTile(
            leading: Icon(Icons.account_circle, color: Colors.deepPurple),
            title: Text("Profile"),
            trailing: Icon(Icons.arrow_forward_ios, size: 16),
          ),
          Divider(),
          ListTile(
            leading: Icon(Icons.lock, color: Colors.deepPurple),
            title: Text("Privacy & Security"),
            trailing: Icon(Icons.arrow_forward_ios, size: 16),
          ),
          Divider(),
          ListTile(
            leading: Icon(Icons.notifications, color: Colors.deepPurple),
            title: Text("Notifications"),
            trailing: Icon(Icons.arrow_forward_ios, size: 16),
          ),
          Divider(),
          ListTile(
            leading: Icon(Icons.help_outline, color: Colors.deepPurple),
            title: Text("Help & Support"),
            trailing: Icon(Icons.arrow_forward_ios, size: 16),
          ),
        ],
      ),
    );
  }
}
