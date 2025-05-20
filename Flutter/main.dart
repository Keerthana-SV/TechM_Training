import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';
import 'core/theme/theme_provider.dart';
import 'presentation/splash_page.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/foundation.dart' show kIsWeb;

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  if (kIsWeb) {
    await Firebase.initializeApp(
      options: const FirebaseOptions(
          apiKey: "AIzaSyDPliWv_b6jkKVS3v6lbyS9aHVykbkK6ZA",
          authDomain: "safetrack-174da.firebaseapp.com",
          projectId: "safetrack-174da",
          storageBucket: "safetrack-174da.appspot.com",
          messagingSenderId: "745254754331",
          appId: "1:745254754331:android:91d47d5b79ba0fbafa80be",
        
      ),
    );
  } else {
    await Firebase.initializeApp();
  }

  SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp])
      .then((_) {
    runApp(
      ChangeNotifierProvider(
        create: (context) => ThemeProvider()..initialize(),
        builder: (context, child) => const MovieApp(),
      ),
    );
  });
}

class MovieApp extends StatelessWidget {
  const MovieApp({super.key});

  @override
  Widget build(BuildContext context) {
    final themeProvider = Provider.of<ThemeProvider>(context);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'CineVerse',
      themeMode: themeProvider.themeMode,
      theme: _buildTheme(Brightness.light, context),
      darkTheme: _buildTheme(Brightness.dark, context),
      home: const SplashPage(),
      onGenerateRoute: _generateRoute,
      locale: const Locale('en', 'US'),
      localizationsDelegates: const [
        DefaultMaterialLocalizations.delegate,
        DefaultWidgetsLocalizations.delegate,
      ],
      supportedLocales: const [Locale('en', 'US')],
      navigatorObservers: [routeObserver],
      builder: (context, child) {
        return GestureDetector(
          onTap: () => FocusManager.instance.primaryFocus?.unfocus(),
          child: child,
        );
      },
    );
  }

  ThemeData _buildTheme(Brightness brightness, BuildContext context) {
    final colorScheme = ColorScheme.fromSeed(
      seedColor: Colors.deepPurple,
      brightness: brightness,
    );

    return ThemeData(
      useMaterial3: true,
      colorScheme: colorScheme,
      appBarTheme: AppBarTheme(
        backgroundColor: colorScheme.surface,
        foregroundColor: colorScheme.onSurface,
        elevation: 0,
      ),
      textTheme: TextTheme(
        displayLarge: TextStyle(
            fontSize: 32,
            fontWeight: FontWeight.bold,
            color: colorScheme.onSurface),
        bodyLarge: TextStyle(
            fontSize: 16, color: colorScheme.onSurface.withOpacity(0.8)),
      ),
      inputDecorationTheme: InputDecorationTheme(
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(12),
        ),
        contentPadding:
            const EdgeInsets.symmetric(horizontal: 16, vertical: 14),
      ),
      filledButtonTheme: FilledButtonThemeData(
        style: FilledButton.styleFrom(
          padding: const EdgeInsets.symmetric(vertical: 16),
          shape:
              RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
        ),
      ),
    );
  }

  Route<dynamic>? _generateRoute(RouteSettings settings) {
    switch (settings.name) {
      // Add named routes here
      default:
        return null;
    }
  }
}

final routeObserver = RouteObserver<PageRoute>();
