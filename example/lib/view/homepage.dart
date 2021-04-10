import 'package:example/constants.dart';
import 'package:example/provider/providers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'data/bottom_bar_list.dart';

class HomePage extends ConsumerWidget {

  @override
  Widget build(BuildContext context, ScopedReader watch){
    final serviceData = watch(serviceprovider);
    // final employeeData =  watch(employeeprovider);
    var serviceList = Lists().getSerciveList(serviceData);
    // var li = watch(serviceListProvider);
    // print(li.state.first.name);
    return serviceList.length!=0?DefaultTabController(
      length: serviceList.length,
      child: Scaffold(
          appBar: AppBar(
            title: Text(khomeTitleId),

            bottom: TabBar(
              isScrollable: true,
              indicatorSize: TabBarIndicatorSize.tab,
              tabs: serviceList.map((e) => new Text(e.name,style:ktabStyle,)).toList(),
            ),
          ),

          body: RefreshIndicator(
            onRefresh: (){
              return context.refresh(serviceprovider);
            },
            child: TabBarView(
              children:serviceList.map((e) => new Center(child: Text(e.id.toString(),style: ktabStyle,))).toList(),
            ),
          )),
    ):ShowError();
  }

}
class ShowError extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(child: Center(child: Text("Some error has occured")),);
  }
}


