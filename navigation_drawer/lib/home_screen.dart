import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    double xOffset=0;
    double yoffset=0;
    double scalefactor=1;
    bool isDrawerOpen = false;
    return AnimatedContainer(
      transform: Matrix4.translationValues(xOffset, yoffset,0)..scale(scalefactor),
      duration: Duration(microseconds: 250),
      color: Colors.white,
      child: Column(
        children: [
          Container(
            margin: EdgeInsets.symmetric(horizontal: 20),
            child: Row(children: [
              isDrawerOpen?IconButton(
                icon: Icon(Icons.arrow_back),
                onPressed: (){
                  setState(() {
                    xOffset=0;
                    yoffset=0;
                    scalefactor=1;
                    isDrawerOpen = true;
                  });
                },
              ):IconButton(onPressed: (){
                setState(() {
                  print("presseed");
                  xOffset = 230;
                  yoffset = 150;
                  scalefactor =0.6;
                  isDrawerOpen  =true;
                });

              }, icon: Icon(Icons.menu)),
              Column(children: [
                Text("Location"),
                Text("Lalsot"),
              ],),
              CircleAvatar(backgroundColor: Colors.blue,)
            ],
            mainAxisAlignment: MainAxisAlignment.spaceBetween,),
          ),


        ],
      ),
      );
  }
}
