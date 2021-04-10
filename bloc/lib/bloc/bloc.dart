import 'dart:async';
import 'package:flutter/material.dart';
enum property{
  Increment,
  Decrement,
  Reset
}
class CounterBLoc{
  int counter;
  final _stateController = StreamController<int>();
  StreamSink<int> get counterSink => _stateController.sink;
  Stream<int> get counterStream =>_stateController.stream;

  final _eventController = StreamController<property>();
  StreamSink<property> get eventSink => _eventController.sink;
  Stream<property> get eventStream =>_eventController.stream;
  CounterBLoc(){
    counter =0;
    eventStream.listen((event) {
      if(event == property.Increment) counter++;
      if(event == property.Decrement) counter--;
      if(event == property.Reset) counter =0;
      counterSink.add(counter);

    });
  }


}