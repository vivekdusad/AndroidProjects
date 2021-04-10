import 'package:example/model/core/user.dart';
import 'package:example/provider/providers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../constants.dart';
class Profile extends ConsumerWidget {
  @override
  Widget build(BuildContext context, ScopedReader watch) {
    final userData = watch(userprovider);
    return Scaffold(
      appBar: AppBar(
        title: Text("Profile"),
      ),
      body: userData.when(
          data: (data) => ProfileWidget(data,context),
          error: (error, stack) => _ErrorWidget(error),
        loading: ()=>Center(child: CircularProgressIndicator(),)
      ),
    );
  }

  Widget ProfileWidget(List<User> data,BuildContext context) {
    var user = data.first;
    return Center(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Image.network(user.photoURL,scale: 20,),
          SizedBox(height: 10,),
          Text("Name: "+user.firstname+" "+user.lastname,style: ktabStyle,),
          Text("Email: "+user.email,style: ktabStyle),
          Text("Phone: "+user.mobileNumber,style: ktabStyle)
        ],
      ),
    );
  }
  Widget _ErrorWidget(Object error) {
 return Text("Something Gone wrong!");
  }

}



