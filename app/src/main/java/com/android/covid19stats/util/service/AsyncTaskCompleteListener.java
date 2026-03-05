
package com.android.covid19stats.util.service;


public interface AsyncTaskCompleteListener<T> {
	public void onTaskComplete(T... params);
}
