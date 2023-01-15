import 'package:flutter/material.dart';
import 'dart:async';
import 'package:camera_plugin/camera_plugin.dart';

late List _myCameras;

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  _myCameras = await availableCameras();
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CameraController? cameraController;

  double previewWidth = 1, previewHeight = 1;

  @override
  void initState() {
    super.initState();
    initCamera();
  }

  Future<void> initCamera() async {
    if (_myCameras.isNotEmpty) {
      cameraController = CameraController(
        _myCameras.first,
        ResolutionPreset.high,
        enableAudio: false,
        scanCaptureChanged: (value) {
          print("returnScanResult: $value");
        },
      );

      await cameraController!.initialize();

      print("camera value: ${cameraController!.value}");

      previewWidth = cameraController!.value.previewSize!.width;
      previewHeight = cameraController!.value.previewSize!.height;
      if (!mounted) {
        return;
      }

      setState(() {});
    }
  }

  @override
  Widget build(BuildContext context) {
    double width = 300;
    double height = (previewWidth / previewHeight) * width;

    double scale = 0.5;

    print("previewWidth: $previewWidth, previewHeight: $previewHeight");

    double scanWidth = width * scale;

    return MaterialApp(
      home: Scaffold(
          body: cameraController == null
              ? Container()
              : Center(
                  child: SizedBox(
                    width: width,
                    height: height,
                    child: Stack(
                      fit: StackFit.expand,
                      children: [
                        CameraPreview(
                          cameraController!,
                          child: TextButton(
                            onPressed: () async {
                              cameraController!.stopScan();
                            },
                            child: Text("turn"),
                          ),
                        ),
                        // Positioned(
                        //     left: width / 2 - scanWidth / 2,
                        //     top: height / 2 - scanWidth / 2,
                        //     child: Container(
                        //       width: scanWidth,
                        //       height: scanWidth,
                        //       color: Colors.red,
                        //     ))
                      ],
                    ),
                  ),
                )),
    );
  }
}
