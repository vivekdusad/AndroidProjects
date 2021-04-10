import 'package:flutter/material.dart';
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
          padding: const EdgeInsets.all(15.0),
          child: SingleChildScrollView(
            child: Column(
              children: [
                lottie(),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text("Sign Up",style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold),),
                    SizedBox(height: 20,),
                    SingleChildScrollView(
                      child: TextField(
                        decoration: InputDecoration(
                            hintText: " First Name",
                            border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                        ),

                      ),
                    ),
                    SizedBox(height: 20,),
                    SingleChildScrollView(
                      child: TextField(
                        decoration: InputDecoration(
                            hintText: " Last Name",
                            border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                        ),

                      ),
                    ),
                    SizedBox(height: 20,),
                    SingleChildScrollView(
                      child: TextField(
                        decoration: InputDecoration(
                            hintText: "Mobile",
                            border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                        ),

                      ),
                    ),
                    SizedBox(height: 20,),
                    SingleChildScrollView(
                      child: TextField(
                        decoration: InputDecoration(
                            hintText: "Email",
                            border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                        ),

                      ),
                    ),
                    SizedBox(height: 20,),
                    SingleChildScrollView(
                      child: TextField(
                        decoration: InputDecoration(
                            hintText: "Password",
                            border: OutlineInputBorder(borderSide: BorderSide(color: Color(0xFFC5CED6),width: 4,style: BorderStyle.solid),)
                        ),

                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.only(right: 40,left: 20,top: 20),
                      child: ElevatedButton(onPressed: (){}, child: Center(child: Text("Sign Up",style: TextStyle(fontSize: 18),),)),
                    ),
                  ],
                ),
              ],
            ),
          ),
        )
      ),
    );
  }
}

class lottie extends StatelessWidget {
  const lottie({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 200,
      width: 200,
      child: Padding(
        padding: const EdgeInsets.all(15.0),
        child: Lottie.network("https://assets3.lottiefiles.com/packages/lf20_AXoQyR.json"),
      ),
    );
  }
}
