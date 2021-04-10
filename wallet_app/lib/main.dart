import 'package:flutter/material.dart';
import 'package:wallet_app/constants.dart';

import 'cardSection.dart';
import 'widget/Header.dart';
import 'package:google_fonts/google_fonts.dart';

void main() {
  runApp(MaterialApp(
    home: MyApp(),
    debugShowCheckedModeBanner: false,
    theme: ThemeData(
      fontFamily:GoogleFonts.roboto().fontFamily ,
      scaffoldBackgroundColor: primaryWhite
    ),
  ));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            Header(),
            CardSection(),
          ],
        ),
      ),
    );
  }
}
