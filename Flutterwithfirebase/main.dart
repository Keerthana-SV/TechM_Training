import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'screens/home_screen.dart';
import 'screens/login_screen.dart';
import 'screens/register_screen.dart';
import 'screens/sos_screen.dart';
import 'screens/map_screen.dart';
import 'screens/settings_screen.dart';
import 'localization/localization_service.dart';
import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);

  runApp(SafeTrackApp());
}

class SafeTrackApp extends StatelessWidget {
  const SafeTrackApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'SafeTrack',
      theme: ThemeData(primarySwatch: Colors.blue),
      locale: LocalizationService.locale,
      supportedLocales: LocalizationService.supportedLocales,
      localizationsDelegates: LocalizationService.delegates,
      initialRoute: '/',
      routes: {
        '/': (context) => LoginScreen(),
        '/register': (context) => RegisterScreen(),
        '/home': (context) => HomeScreen(),
        '/sos': (context) => SOSScreen(),
        '/map': (context) => MapScreen(),
        '/settings': (context) => SettingsScreen(),
      },
    );
  }
}
