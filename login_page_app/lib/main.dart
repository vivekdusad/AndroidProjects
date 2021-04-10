import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:lottie/lottie.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Padding(
          padding: const EdgeInsets.only(left: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              lottie(),
              Text("Login",style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold),),
              Padding(
                padding: const EdgeInsets.only(top: 15,right: 15),
                child: TextField(
                  decoration: InputDecoration(
                    hintText: "Email",
                    border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                  ),

                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 15,right: 15),
                child: TextField(
                  decoration: InputDecoration(
                      hintText: "Password",
                      border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                  ),

                ),
              ),
              Padding(
                padding: const EdgeInsets.only(right: 40,left: 20,top: 20),
                child: ElevatedButton(onPressed: (){}, child: Center(child: Text("Login",style: TextStyle(fontSize: 18),),)),
              ),
              SizedBox(height: 30,),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Padding(
                    padding: const EdgeInsets.all(15.0),
                    child: Container(
                      child: Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Icon(FontAwesomeIcons.google),
                      ),
                      decoration: BoxDecoration(
                        border: Border.all(color: Colors.blue,width: 3,style: BorderStyle.solid)
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(15.0),
                    child: Container(
                      child: Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Icon(FontAwesomeIcons.facebook),
                      ),
                      decoration: BoxDecoration(
                          border: Border.all(color: Colors.blue,width: 3,style: BorderStyle.solid)
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(15.0),
                    child: Container(
                      child: Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Icon(FontAwesomeIcons.phone),
                      ),
                      decoration: BoxDecoration(
                          border: Border.all(color: Colors.blue,width: 3,style: BorderStyle.solid)
                      ),
                    ),
                  ),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}

// ignore: camel_case_types
class lottie extends StatelessWidget {
  const lottie({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400,
      width: 400,
      child: Lottie.network("https://assets5.lottiefiles.com/packages/lf20_yupefrh2.json",
      repeat: true,
      animate: true),
    );
  }
}
