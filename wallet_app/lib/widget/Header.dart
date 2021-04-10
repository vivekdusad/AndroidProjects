import 'package:flutter/material.dart';
import 'package:wallet_app/constants.dart';

class Header extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 20),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text("Vivek's Wallet", style: TextStyle(fontSize: 25,fontWeight: FontWeight.bold,decoration: TextDecoration.none,color: Colors.black),),
          Container(
            height: 50,
            width: 50,
            child: Stack(
              children: [
                Center(
                  child: Container(
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: Colors.deepOrange,
                      boxShadow: neumorpShadow,
                    ),

                  ),
                ),
                Center(
                  child: Container(
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: primaryWhite,
                      boxShadow: neumorpShadow,
                    ),
                    margin: EdgeInsets.all(6),

                  ),
                ),
                Center(
                  child: Icon(Icons.notifications),
                )

              ],
            ),
          ),
        ],
      ),
    );
  }
}
