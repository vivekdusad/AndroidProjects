import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {


  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: TextButton(
          onPressed:()=> _ButtonPressed(),
          child: Text("btn"),
        ),
      ),
    );
  }
  void _ButtonPressed(){
    showModalBottomSheet(context: context,builder: (context){
      return Column(
        children: [
          ListTile(
            leading: Icon(Icons.location_on),
            title: Text("Location"),
            onTap: (){

            },
          )
        ],
      );
    });
  }
}
