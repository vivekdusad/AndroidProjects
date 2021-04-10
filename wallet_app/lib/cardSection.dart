import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:wallet_app/constants.dart';

class CardSection extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Container(
          alignment: Alignment.topLeft,
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Text(
              "Selected Card",
              style: TextStyle(fontWeight: FontWeight.bold,fontSize: 20),

            ),
          ),
        ),
        Container(
          decoration: BoxDecoration(
              boxShadow: neumorpShadow,
              color: primaryWhite,
              borderRadius: BorderRadius.circular(20)),
          margin: EdgeInsets.symmetric(vertical: 40, horizontal: 20),
          width: MediaQuery.of(context).size.width,
          height: 300,
          child: Stack(
            children: [
              Positioned.fill(
                top:150,
                bottom: -150,
                child: Container(
                  decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: Colors.white38,
                      boxShadow: neumorpShadow
                  ),
                ),
              ),
              Positioned.fill(
                top: -100,
                left: -340,
                bottom: -100,
                child: Container(
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    color: Colors.white38,
                    boxShadow: neumorpShadow
                  ),
                ),
              ),
          Image.asset(
            "assets/mastercardlogo.png")

            ],
          ),
        ),
      ],
    );
  }
}

// Expanded(
// child: ListView.builder(
// scrollDirection: Axis.horizontal,
// itemCount: 2,
// physics: BouncingScrollPhysics(),
// itemBuilder: (context, index) {
// return Container(
// width: MediaQuery.of(context).size.width,
// margin: EdgeInsets.symmetric(horizontal: 20,vertical: 40),
// decoration: BoxDecoration(color: primaryWhite,boxShadow: neumorpShadow,),
// );
// },
// ),
