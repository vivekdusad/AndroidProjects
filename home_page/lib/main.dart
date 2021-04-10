import 'package:flutter/material.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';

void main() {
  runApp(MyApp());
}

const Color kPrimaryColor = Color(0xFF209CFF);
const Color kSecondryColor = Color(0xFFB6B6B6);
const Color kWhiteColor = Color(0xFFEDEDED);

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: SafeArea(
          child: Stack(
            children: [
              StackBody(),
              BottomBody(),
            ],
          ),
        ),
      ),
    );
  }
}

class BottomBody extends StatelessWidget {
  const BottomBody({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Align(
      child: Container(
        height: 50,
        decoration: BoxDecoration(
          color: kPrimaryColor,
          borderRadius: BorderRadius.only(
            topLeft: Radius.circular(1000),
            topRight: Radius.circular(1000),
          ),
        ),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Icon(
              Icons.home,
              color: Colors.white,
            ),
            Icon(
              Icons.search,
              color: Colors.white,
            ),
            Icon(
              Icons.history,
              color: Colors.white,
            ),
            Icon(
              Icons.person,
              color: Colors.white,
            ),
          ],
        ),
      ),
      alignment: Alignment.bottomCenter,
    );
  }
}

class StackBody extends StatelessWidget {
  const StackBody({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    List<String> services=["plumber","plumber","plumber","plumber","plumber","plumber","plumber","plumber","plumber"];
    List<Widget> widgets = services.map((name) => new Text(name)).toList();
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
      ),
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(4.0),
                    child: Icon(Icons.menu),
                  ),
                  decoration: BoxDecoration(border: Border.all(color: kPrimaryColor,style: BorderStyle.solid)),
                ),
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(4.0),
                    child: Icon(Icons.settings),
                  ),
                  decoration: BoxDecoration(border: Border.all(color: kPrimaryColor,style: BorderStyle.solid)),
                ),
              ],
            ),
            SizedBox(height: 50,),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Container(child: Icon(Icons.location_on),),
                    SizedBox(width: 5,),
                    Text("Lalsot",style: TextStyle(fontSize: 18),)
                  ],
                ),
                SizedBox(height: 50,),
                Text("Categories",
                style: TextStyle(
                  fontSize: 25
                ),),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Card(child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Text("Plumber",style: TextStyle(fontSize: 18),),
                ),),
                Container(child: Text("Plumber",style: TextStyle(fontSize: 18),),),
                GridView.count(crossAxisCount: 4,
                shrinkWrap: true,
                physics: ScrollPhysics(),
                children:widgets,
                ),
              ],
            )
          ],
        ),
      ),
    );
  }
}
