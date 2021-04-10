import 'package:flutter/material.dart';
import 'package:navigation_drawer/constant.dart';
import 'package:navigation_drawer/home_screen.dart';
import 'package:navigation_drawer/navigation.dart';

void main() {
  runApp(MaterialApp(home: MyApp(),debugShowCheckedModeBanner: false,));
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Stack(
          children: [
            Navigation(),
            HomePage(),

          ],
        ),
      ),
    );
  }
}
