import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  List<String> _list =["Plumber","Plumber","Plumber","Plumber","Plumber","Plumber","Plumber","Plumber"];
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: Text("Plumbers",style: TextStyle(fontSize: 30),),
              ),
              Expanded(
                child: ListView.builder(
                  shrinkWrap: true,
                  scrollDirection: Axis.vertical,
                  itemBuilder: (BuildContext context,int index){
                    return CardItem(title: _list[index],);},
                  itemCount: _list.length,
                ),
              ),
            ],
          ),

        ),
      ),
    );
  }
}

class CardItem extends StatelessWidget {
  CardItem({
    this.title="Electrican",
});
  final String title;
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(10),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(5),
        child: Container(
          height: 120,
            decoration: BoxDecoration(
              border: Border.all(color: Color(0xFFCBD6DE),width: 3,style: BorderStyle.solid)
            ),
          child: Padding(
            padding: const EdgeInsets.only(left: 2,top: 6,right: 10,bottom: 5),
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Image.network("https://images.unsplash.com/photo-1599566150163-29194dcaad36?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                height: 100,
                width: 100,),
                Text(title,style: TextStyle(fontSize: 20,fontWeight: FontWeight.w600),),
                Column(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  crossAxisAlignment: CrossAxisAlignment.end,
                  children: [
                    Container(decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: Colors.green
                    ),
                    width: 25,
                    height: 25,),
                    RatingBar.builder(
                      itemCount: 5,
                      initialRating: 4,
                      direction: Axis.horizontal,
                      allowHalfRating: true,
                      itemBuilder: (context,_)=>Icon(Icons.star,color: Colors.amber,),
                      onRatingUpdate: (rating){{
                        print(rating);
                      }},
                      itemSize: 25,
                    )
                  ],
                )
              ],
            ),
          )
        ),
      ),
    );
  }
}
