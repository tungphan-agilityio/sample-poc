package agility.tungphan.poc.mylibrary

import agility.tungphan.poc.mylibrary.models.RegistrationData
import agility.tungphan.poc.mylibrary.ui.FirstActivity
import android.app.Activity
import android.content.Intent

class AuthenticationManager private constructor() {

    companion object {
        private var instance: AuthenticationManager? = null
        fun getInstance(): AuthenticationManager {
            if (instance == null) {
                synchronized(this) {
                    instance = AuthenticationManager()
                }
            }
            return instance!!
        }
    }

    internal var onOnboardingCompleted: ((RegistrationData) -> Unit)? = null
    internal var onLoginCompleted: (() -> Unit)? = null
    internal var startActivity: Activity? = null

    fun register(onOnboardingCompleted: ((RegistrationData) -> Unit)? = null, onLoginCompleted: (() -> Unit)? = null) {
        this.onOnboardingCompleted = onOnboardingCompleted
        this.onLoginCompleted = onLoginCompleted
    }

    fun startOnboarding(activity: Activity) {
        startActivity = activity;
        activity.startActivity(Intent(activity, FirstActivity::class.java))
    }

    fun cleanUp() {
        this.startActivity = null
        this.onLoginCompleted = null
        this.onOnboardingCompleted = null
    }
}