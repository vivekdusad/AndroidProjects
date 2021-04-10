import 'package:bloc/bloc/bloc.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  final counterBloc = CounterBLoc();
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          child :Center(child: StreamBuilder(
            stream:counterBloc.counterStream ,
            initialData: 0,
            builder: (context,snapshot){
                return Text(snapshot.data.toString());
          },),

          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: (){
            counterBloc.eventSink.add(property.Increment);
          },
        ),
      ),
    );
  }
}
