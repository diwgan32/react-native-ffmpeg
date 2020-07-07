package com.arthenica.reactnative;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;

import com.arthenica.mobileffmpeg.FFmpeg;

import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;


public class FFMpegAsyncWorker extends Worker {
  private static final String TAG = FFMpegAsyncWorker.class.getSimpleName();

  public FFMpegAsyncWorker(
       @NonNull Context context,
       @NonNull WorkerParameters params) {
       super(context, params);
       Log.d(TAG, String.format("Working constructor"));
   }

   @Override
   public Result doWork() {
      String[] args = getInputData().getStringArray("ARGS");
      FFmpeg.execute(args);
      
      Log.d(TAG, String.format("Done with ffmpeg!"));
      return Result.success();

     
   }
}