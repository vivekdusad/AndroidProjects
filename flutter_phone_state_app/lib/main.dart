import 'package:flutter/material.dart';
import 'package:flutter_phone_direct_caller/flutter_phone_direct_caller.dart';
import 'package:call_log/call_log.dart';
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  var entries;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: Container(
            child: TextButton(
              child: Text("call",style: TextStyle(fontSize: 20),),
              onPressed:() async{
                // await FlutterPhoneDirectCaller.callNumber("8302135675");
                Iterable<CallLogEntry> entries = await CallLog.get();
                var now = DateTime.now();
                int from = now.subtract(Duration(days: 60)).millisecondsSinceEpoch;
                int to = now.subtract(Duration(days: 30)).millisecondsSinceEpoch;
                entries = await CallLog.query(

                  type: CallType.outgoing,
                );
                for(int i=1;i<10;i++){
                  print(entries.elementAt(i).number);
                }

              },
            ),
          ),
        ),
      ),
    );
  }
  _callNumber() async {

  }
}
