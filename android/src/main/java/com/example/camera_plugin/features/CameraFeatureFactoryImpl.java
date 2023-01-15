// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.example.camera_plugin.features;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.example.camera_plugin.CameraProperties;
import com.example.camera_plugin.DartMessenger;
import com.example.camera_plugin.features.autofocus.AutoFocusFeature;
import com.example.camera_plugin.features.exposurelock.ExposureLockFeature;
import com.example.camera_plugin.features.exposureoffset.ExposureOffsetFeature;
import com.example.camera_plugin.features.exposurepoint.ExposurePointFeature;
import com.example.camera_plugin.features.flash.FlashFeature;
import com.example.camera_plugin.features.focuspoint.FocusPointFeature;
import com.example.camera_plugin.features.fpsrange.FpsRangeFeature;
import com.example.camera_plugin.features.noisereduction.NoiseReductionFeature;
import com.example.camera_plugin.features.resolution.ResolutionFeature;
import com.example.camera_plugin.features.resolution.ResolutionPreset;
import com.example.camera_plugin.features.sensororientation.SensorOrientationFeature;
import com.example.camera_plugin.features.zoomlevel.ZoomLevelFeature;

/**
 * Implementation of the {@link CameraFeatureFactory} interface creating the supported feature
 * implementation controlling different aspects of the {@link
 * android.hardware.camera2.CaptureRequest}.
 */
public class CameraFeatureFactoryImpl implements CameraFeatureFactory {

  @Override
  public AutoFocusFeature createAutoFocusFeature(
      @NonNull CameraProperties cameraProperties, boolean recordingVideo) {
    return new AutoFocusFeature(cameraProperties, recordingVideo);
  }

  @Override
  public ExposureLockFeature createExposureLockFeature(@NonNull CameraProperties cameraProperties) {
    return new ExposureLockFeature(cameraProperties);
  }

  @Override
  public ExposureOffsetFeature createExposureOffsetFeature(
      @NonNull CameraProperties cameraProperties) {
    return new ExposureOffsetFeature(cameraProperties);
  }

  @Override
  public FlashFeature createFlashFeature(@NonNull CameraProperties cameraProperties) {
    return new FlashFeature(cameraProperties);
  }

  @Override
  public ResolutionFeature createResolutionFeature(
      @NonNull CameraProperties cameraProperties,
      ResolutionPreset initialSetting,
      String cameraName) {
    return new ResolutionFeature(cameraProperties, initialSetting, cameraName);
  }

  @Override
  public FocusPointFeature createFocusPointFeature(
      @NonNull CameraProperties cameraProperties,
      @NonNull SensorOrientationFeature sensorOrientationFeature) {
    return new FocusPointFeature(cameraProperties, sensorOrientationFeature);
  }

  @Override
  public FpsRangeFeature createFpsRangeFeature(@NonNull CameraProperties cameraProperties) {
    return new FpsRangeFeature(cameraProperties);
  }

  @Override
  public SensorOrientationFeature createSensorOrientationFeature(
      @NonNull CameraProperties cameraProperties,
      @NonNull Activity activity,
      @NonNull DartMessenger dartMessenger) {
    return new SensorOrientationFeature(cameraProperties, activity, dartMessenger);
  }

  @Override
  public ZoomLevelFeature createZoomLevelFeature(@NonNull CameraProperties cameraProperties) {
    return new ZoomLevelFeature(cameraProperties);
  }

  @Override
  public ExposurePointFeature createExposurePointFeature(
      @NonNull CameraProperties cameraProperties,
      @NonNull SensorOrientationFeature sensorOrientationFeature) {
    return new ExposurePointFeature(cameraProperties, sensorOrientationFeature);
  }

  @Override
  public NoiseReductionFeature createNoiseReductionFeature(
      @NonNull CameraProperties cameraProperties) {
    return new NoiseReductionFeature(cameraProperties);
  }
}
