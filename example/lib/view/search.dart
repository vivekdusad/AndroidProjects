import 'package:example/constants.dart';
import 'package:flutter/material.dart';
class Search extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Search"),
      ),
      body: Center(child: Text("Search Page",style: ktabStyle,)),
    );
  }
}
