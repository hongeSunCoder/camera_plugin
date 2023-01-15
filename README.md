# camera_plugin

Add scan component to flutter camera plugin for ios 
// android to do.



```dart

List<CameraDescription> myCameras = await availableCameras();

for (final camera in myCameras) {
    if (camera.lensDirection == CameraLensDirection.back) {
        cameraController = CameraController(camera, ResolutionPreset.max,
        enableAudio: false, scanCaptureChanged: (value) {

            // get scan result
        });
    } else if (camera.lensDirection == CameraLensDirection.front) {}
}


// in widget tree
if (cameraController != null) 
    CameraPreview(cameraController!),

          
```