import 'package:flutter/material.dart';

class ThemeProvider extends ChangeNotifier {
  ThemeMode _themeMode = ThemeMode.system;

  ThemeMode get themeMode => _themeMode;
  bool get isDarkMode => _themeMode == ThemeMode.dark;

  void toggleTheme(bool isOn) {
    _themeMode = isOn ? ThemeMode.dark : ThemeMode.light;
    notifyListeners();
  }

  Future<void> initialize() async {
    // Example: Load saved theme preference from SharedPreferences or local storage
    // final prefs = await SharedPreferences.getInstance();
    // final isDark = prefs.getBool('isDarkMode') ?? false;
    // _themeMode = isDark ? ThemeMode.dark : ThemeMode.light;
    // notifyListeners();
  }
}
