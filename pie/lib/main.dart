import 'package:flutter/material.dart';

import 'package:provider/provider.dart';

import 'home_screen.dart';
import 'itemaddnotifier.dart';

void main() {
  runApp(HomeApp());
}
class HomeApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<ItemAddNotifier>(
      create: (BuildContext context) {
        return ItemAddNotifier();
      },
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        home: HomeScreen(),
      ),
    );
  }
}
