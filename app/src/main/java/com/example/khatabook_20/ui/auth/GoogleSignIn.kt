package com.example.khatabook_20.auth//package com.example.khatabook_20
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.firebase.auth.AuthCredential
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.GoogleAuthProvider
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//
//
//class GoogleSignIn : AppCompatActivity() {
//    companion object {
//        private const val TAG = "GoogleActivity"
//        private const val RC_SIGN_IN = 420
//    }
//
//    private lateinit var mGoogleSignInClient: GoogleSignInClient
//    private lateinit var mAuth: FirebaseAuth
//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser: FirebaseUser? = mAuth.currentUser
//        updateUI(currentUser)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_sign_in)
//        supportActionBar!!.hide()
//
//        mAuth = Firebase.auth
//        // Configure sign-in to request the user's ID, email address, and basic
//        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        // Build a GoogleSignInClient with the options specified by gso.
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//        findViewById<View>(R.id.signupwithgoogle).setOnClickListener {
//            signIn()
//        }
//    }
//
//    private fun signIn() {
//        val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//    }
//
//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                val account = task.getResult(ApiException::class.java)
//                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId())
//                firebaseAuthWithGoogle(account.idToken!!)
//            } catch (e: ApiException) {
//                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e)
//            }
//        }
//    }
//
//    private fun firebaseAuthWithGoogle(idToken: String) {
//        val credential: AuthCredential = GoogleAuthProvider.getCredential(idToken, null)
//        mAuth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful()) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithCredential:success")
//                    val user = mAuth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithCredential:failure", task.getException())
//                    updateUI(null)
//                }
//            }
//    }
//
//
//    private fun updateUI(user: FirebaseUser?) {
//        if (user != null) {
//            val intent = Intent(this@GoogleSignIn, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//
//    }
//}