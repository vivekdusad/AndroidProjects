import 'package:flutter/material.dart';
import 'package:pie/itemaddnotifier.dart';
import 'package:provider/provider.dart';

class SecondScreen extends StatelessWidget {
  final TextEditingController _itemNameController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Second Page"),
      ),
      body: Column(
        children: [
          TextField(
            controller: _itemNameController,
            decoration: InputDecoration(
              contentPadding: EdgeInsets.all(15.0),
              hintText: 'Item Name',
            ),
          ),
          SizedBox(
            height: 20.0,
          ),
          RaisedButton(
            child: Text('ADD ITEM'),
            onPressed: () async {
              if (_itemNameController.text.isEmpty) {
                return;
              }
              await Provider.of<ItemAddNotifier>(context, listen: false)
                  .addItem(_itemNameController.text);
              Navigator.pop(context);
            },
          )
        ],
      ),
    );
  }
}
