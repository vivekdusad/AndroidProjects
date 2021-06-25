import 'package:flutter/material.dart';
import 'package:flutter_phone_direct_caller/flutter_phone_direct_caller.dart';
import 'package:call_log/call_log.dart';
import 'package:flutter_phone_state/flutter_phone_state.dart';

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
              child: Text(
                "call",
                style: TextStyle(fontSize: 20),
              ),
              onPressed: () async {
                // await FlutterPhoneDirectCaller.callNumber("9468586954");
                final phonecall =
                    FlutterPhoneState.startPhoneCall("9468586954");
                print("call is Finished");
                // Iterable<CallLogEntry> entries = await CallLog.get();
                // entries = await CallLog.query(
                //   type: CallType.outgoing,
                // );
                // for(int i=1;i<10;i++){
                //   print(entries.elementAt(i).number);
                // }
              },
            ),
          ),
        ),
      ),
    );
  }
}
