package com.example.myapplication6484

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication6484.databinding.Nivel1Binding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class nivel1Casi : Fragment() {

    //private lateinit var mp:MediaPlayer
    private var mp: MediaPlayer? = null
    private val hideHandler = Handler(Looper.myLooper()!!)

    @Suppress("InlinedApi")
    private val hidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        val flags =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        activity?.window?.decorView?.systemUiVisibility = flags
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }
    private val showPart2Runnable = Runnable {
        // Delayed display of UI elements
        fullscreenContentControls?.visibility = View.VISIBLE
    }
    private var visible: Boolean = false
    //private val hideRunnable = Runnable { hide() }
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */

    private var dummyButton: Button? = null
    private var fullscreenContent: View? = null
    private var fullscreenContentControls: View? = null

    private var _binding: Nivel1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = Nivel1Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val  mp = MediaPlayer.create(this, R.raw.uff)
        var contador = 0
        var contador2 = ""
        var contador3 = 0
        var contadorFallo = 0


        //ToggleButton tgbn;
        //tgbn =  (ToggleButton)findViewById(R.id.toggleButton);
        visible = true


        // Set up the user interaction to manually show or hide the system UI.
        // fullscreenContent?.setOnClickListener { toggle() }

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

        //grupo de radio buttons en nivel 1.1 respuesta correcta boton 3 "U"

        //tercera
        binding.radioGroup1.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton11) {
                // mp.start()
                binding.botonAceptar1.setOnClickListener {
                    binding.linearVuelveIntentarlo1.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton12) {
                binding.botonAceptar1.setOnClickListener {
                    binding.linearVuelveIntentarlo1.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton13) {
                binding.botonAceptar1.setOnClickListener {


                    binding.linearVuelveIntentarlo1.visibility = View.GONE
                    binding.siguiente1.visibility = View.VISIBLE
                    binding.botonAceptar1.visibility = View.GONE
                    binding.linearContenido1.visibility = View.GONE
                    binding.linearLuz1.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto1.visibility = View.VISIBLE
                        binding.linearPerfecto1.visibility = View.VISIBLE
                        binding.siguiente1.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto1.visibility = View.VISIBLE
                        binding.linearBien1.visibility = View.VISIBLE
                        binding.siguiente1.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto1.visibility = View.VISIBLE
                        binding.linearMal1.visibility = View.VISIBLE
                        binding.siguiente1.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }
            }
        }
/*
        //primera correcta
        binding.radioGroup2.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton21) {
                // mp.start()
                binding.botonAceptar2.setOnClickListener {


                    binding.linearVuelveIntentarlo2.visibility = View.GONE
                    binding.siguiente2.visibility = View.VISIBLE
                    binding.botonAceptar2.visibility = View.GONE
                    binding.linearContenido2.visibility = View.GONE
                    binding.linearSol1.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto2.visibility = View.VISIBLE
                        binding.linearPerfecto2.visibility = View.VISIBLE
                        binding.siguiente2.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto2.visibility = View.VISIBLE
                        binding.linearBien2.visibility = View.VISIBLE
                        binding.siguiente2.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto2.visibility = View.VISIBLE
                        binding.linearMal2.visibility = View.VISIBLE
                        binding.siguiente2.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }


            }

            if (i == R.id.radioButton22) {
                binding.botonAceptar2.setOnClickListener {
                    binding.linearVuelveIntentarlo2.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton23) {
                binding.botonAceptar2.setOnClickListener {
                    binding.linearVuelveIntentarlo2.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }
        }

        //segunda correta
        binding.radioGroup3.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton31) {
                // mp.start()
                binding.botonAceptar3.setOnClickListener {
                    binding.linearVuelveIntentarlo3.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }


            }
            if (i == R.id.radioButton32) {


                binding.botonAceptar3.setOnClickListener {


                    binding.linearVuelveIntentarlo3.visibility = View.GONE
                    binding.siguiente3.visibility = View.VISIBLE
                    binding.botonAceptar3.visibility = View.GONE
                    binding.linearContenido3.visibility = View.GONE
                    binding.linearRio.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto3.visibility = View.VISIBLE
                        binding.linearPerfecto3.visibility = View.VISIBLE
                        binding.siguiente3.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto3.visibility = View.VISIBLE
                        binding.linearBien3.visibility = View.VISIBLE
                        binding.siguiente3.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto3.visibility = View.VISIBLE
                        binding.linearMal3.visibility = View.VISIBLE
                        binding.siguiente3.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }
            }

            if (i == R.id.radioButton33) {
                binding.botonAceptar3.setOnClickListener {
                    binding.linearVuelveIntentarlo3.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }


        }

        //tercera correcta
        binding.radioGroup4.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton41) {
                // mp.start()
                binding.botonAceptar4.setOnClickListener {
                    binding.linearVuelveIntentarlo4.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }


            }
            if (i == R.id.radioButton42) {

                binding.botonAceptar4.setOnClickListener {
                    binding.linearVuelveIntentarlo4.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }

            }

            if (i == R.id.radioButton43) {


                binding.botonAceptar4.setOnClickListener {


                    binding.linearVuelveIntentarlo4.visibility = View.GONE
                    binding.siguiente4.visibility = View.VISIBLE
                    binding.botonAceptar4.visibility = View.GONE
                    binding.linearContenido4.visibility = View.GONE
                    binding.linearRio.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto4.visibility = View.VISIBLE
                        binding.linearPerfecto4.visibility = View.VISIBLE
                        binding.siguiente4.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto4.visibility = View.VISIBLE
                        binding.linearBien4.visibility = View.VISIBLE
                        binding.siguiente4.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto4.visibility = View.VISIBLE
                        binding.linearMal4.visibility = View.VISIBLE
                        binding.siguiente4.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }
            }


        }

        //primera
        binding.radioGroup5.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton51) {
                // mp.start()
                binding.botonAceptar5.setOnClickListener {


                    binding.linearVuelveIntentarlo5.visibility = View.GONE
                    binding.siguiente5.visibility = View.VISIBLE
                    binding.botonAceptar5.visibility = View.GONE
                    binding.linearContenido5.visibility = View.GONE
                    binding.linearDos.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto5.visibility = View.VISIBLE
                        binding.linearPerfecto5.visibility = View.VISIBLE
                        binding.siguiente5.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto5.visibility = View.VISIBLE
                        binding.linearBien5.visibility = View.VISIBLE
                        binding.siguiente5.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto5.visibility = View.VISIBLE
                        binding.linearMal5.visibility = View.VISIBLE
                        binding.siguiente5.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }


            }

            if (i == R.id.radioButton52) {
                binding.botonAceptar5.setOnClickListener {
                    binding.linearVuelveIntentarlo5.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton53) {
                binding.botonAceptar5.setOnClickListener {
                    binding.linearVuelveIntentarlo5.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }
        }


        //tercera
        binding.radioGroup6.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton61) {
                // mp.start()
                binding.botonAceptar6.setOnClickListener {
                    binding.linearVuelveIntentarlo6.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton62) {
                binding.botonAceptar6.setOnClickListener {
                    binding.linearVuelveIntentarlo6.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton63) {
                binding.botonAceptar6.setOnClickListener {


                    binding.linearVuelveIntentarlo6.visibility = View.GONE
                    binding.siguiente6.visibility = View.VISIBLE
                    binding.botonAceptar6.visibility = View.GONE
                    binding.linearContenido6.visibility = View.GONE
                    binding.linearOjo6.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto6.visibility = View.VISIBLE
                        binding.linearPerfecto6.visibility = View.VISIBLE
                        binding.siguiente6.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto6.visibility = View.VISIBLE
                        binding.linearBien6.visibility = View.VISIBLE
                        binding.siguiente6.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto6.visibility = View.VISIBLE
                        binding.linearMal6.visibility = View.VISIBLE
                        binding.siguiente6.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }
            }
        }
        */
/*
        //primera correcta
        binding.radioGroup7.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton71) {
                // mp.start()
                binding.botonAceptar7.setOnClickListener {


                    binding.linearVuelveIntentarlo7.visibility = View.GONE
                    binding.siguiente7.visibility = View.VISIBLE
                    binding.botonAceptar7.visibility = View.GONE
                    binding.linearContenido7.visibility = View.GONE
                    binding.linearAve.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto7.visibility = View.VISIBLE
                        binding.linearPerfecto7.visibility = View.VISIBLE
                        binding.siguiente7.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto7.visibility = View.VISIBLE
                        binding.linearBien7.visibility = View.VISIBLE
                        binding.siguiente7.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto7.visibility = View.VISIBLE
                        binding.linearMal7.visibility = View.VISIBLE
                        binding.siguiente7.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }


            }

            if (i == R.id.radioButton72) {
                binding.botonAceptar7.setOnClickListener {
                    binding.linearVuelveIntentarlo7.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton73) {
                binding.botonAceptar7.setOnClickListener {
                    binding.linearVuelveIntentarlo7.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }
        }

        //segunda correta
        binding.radioGroup8.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton81) {
                // mp.start()
                binding.botonAceptar8.setOnClickListener {
                    binding.linearVuelveIntentarlo8.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }


            }
            if (i == R.id.radioButton82) {


                binding.botonAceptar8.setOnClickListener {


                    binding.linearVuelveIntentarlo8.visibility = View.GONE
                    binding.siguiente8.visibility = View.VISIBLE
                    binding.botonAceptar8.visibility = View.GONE
                    binding.linearContenido8.visibility = View.GONE
                    binding.linearFlor.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto8.visibility = View.VISIBLE
                        binding.linearPerfecto8.visibility = View.VISIBLE
                        binding.siguiente8.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto8.visibility = View.VISIBLE
                        binding.linearBien8.visibility = View.VISIBLE
                        binding.siguiente8.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto8.visibility = View.VISIBLE
                        binding.linearMal8.visibility = View.VISIBLE
                        binding.siguiente8.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }
            }

            if (i == R.id.radioButton83) {
                binding.botonAceptar8.setOnClickListener {
                    binding.linearVuelveIntentarlo8.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }


        }

        //tercera correcta
        binding.radioGroup9.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton91) {
                // mp.start()
                binding.botonAceptar9.setOnClickListener {
                    binding.linearVuelveIntentarlo9.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }


            }
            if (i == R.id.radioButton92) {

                binding.botonAceptar9.setOnClickListener {
                    binding.linearVuelveIntentarlo9.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }

            }

            if (i == R.id.radioButton93) {


                binding.botonAceptar9.setOnClickListener {


                    binding.linearVuelveIntentarlo9.visibility = View.GONE
                    binding.siguiente9.visibility = View.VISIBLE
                    binding.botonAceptar9.visibility = View.GONE
                    binding.linearContenido9.visibility = View.GONE
                    binding.linearRed.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto9.visibility = View.VISIBLE
                        binding.linearPerfecto9.visibility = View.VISIBLE
                        binding.siguiente9.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto9.visibility = View.VISIBLE
                        binding.linearBien9.visibility = View.VISIBLE
                        binding.siguiente9.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto9.visibility = View.VISIBLE
                        binding.linearMal9.visibility = View.VISIBLE
                        binding.siguiente9.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }
            }


        }

        //primera
        binding.radioGroup0.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radioButton01) {
                // mp.start()
                binding.botonAceptar0.setOnClickListener {


                    binding.linearVuelveIntentarlo0.visibility = View.GONE
                    binding.siguiente0.visibility = View.VISIBLE
                    binding.botonAceptar0.visibility = View.GONE
                    binding.linearContenido0.visibility = View.GONE
                    binding.linearDia.visibility = View.VISIBLE

                    if (contadorFallo == 0) {
                        binding.textCorrecto0.visibility = View.VISIBLE
                        binding.linearPerfecto0.visibility = View.VISIBLE
                        binding.siguiente0.visibility = View.VISIBLE
                    }
                    if (contadorFallo == 1) {
                        binding.textCorrecto0.visibility = View.VISIBLE
                        binding.linearBien0.visibility = View.VISIBLE
                        binding.siguiente0.visibility = View.VISIBLE
                    }
                    if (contadorFallo >= 2) {
                        binding.textCorrecto0.visibility = View.VISIBLE
                        binding.linearMal0.visibility = View.VISIBLE
                        binding.siguiente0.visibility = View.VISIBLE
                    }
                    if (contador in 0..9) {
                        contador += 1
                        contador2 = contador.toString()

                        binding.progressBar2.progress = contador

                        binding.textView9.setText("$contador2/10")
                        contador3 = contador
                    }
                }


            }

            if (i == R.id.radioButton02) {
                binding.botonAceptar0.setOnClickListener {
                    binding.linearVuelveIntentarlo0.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }

            if (i == R.id.radioButton03) {
                binding.botonAceptar0.setOnClickListener {
                    binding.linearVuelveIntentarlo0.visibility = View.VISIBLE
                    contadorFallo = contadorFallo + 1
                }
            }
        }
*/
        //cambios de interfaces
/*
        binding.siguiente1.setOnClickListener {
            binding.lay1.visibility = View.GONE
            binding.lay2.visibility = View.VISIBLE
            contadorFallo = 0
        }
        binding.siguiente2.setOnClickListener {
            binding.lay2.visibility = View.GONE
            binding.lay3.visibility = View.VISIBLE
            contadorFallo = 0
        }
        binding.siguiente3.setOnClickListener {
            binding.lay3.visibility = View.GONE
            binding.lay4.visibility = View.VISIBLE
            contadorFallo = 0
        }
        binding.siguiente4.setOnClickListener {
            binding.lay4.visibility = View.GONE
            binding.lay5.visibility = View.VISIBLE
            contadorFallo = 0
        }

        binding.siguiente5.setOnClickListener {
            binding.lay5.visibility = View.GONE
            binding.lay6.visibility = View.VISIBLE
            contadorFallo = 0
        }

        binding.siguiente6.setOnClickListener {
            binding.lay6.visibility = View.GONE
            contadorFallo = 0
            findNavController().navigate(R.id.action_nivel1Casi_to_continuacion)

        }
        */
        /*
               binding.siguiente6.setOnClickListener {
                   binding.lay6.visibility = View.GONE
                   binding.lay8.visibility= View.VISIBLE
                   contadorFallo = 0
               }
               binding.siguiente8.setOnClickListener {
                   binding.lay8.visibility = View.GONE
                   binding.lay9.visibility= View.VISIBLE
                   contadorFallo = 0
               }
               binding.siguiente9.setOnClickListener {
                   binding.lay9.visibility = View.GONE
                   //binding.lay0.visibility= View.VISIBLE
                   contadorFallo = 0
               }

                */
    }



//
    //
    //
    //Inicio de comentado
/*
    override fun onResume() {
        super.onResume()

        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        //delayedHide(100)
    }

    override fun onPause() {
        super.onPause()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Clear the systemUiVisibility flag
        activity?.window?.decorView?.systemUiVisibility = 0
        //show()
    }

    override fun onDestroy() {
        super.onDestroy()
        dummyButton = null
        fullscreenContent = null
        fullscreenContentControls = null
    }

    private fun toggle() {
        if (visible) {
            hide()
        } else {
            show()
        }
    }

    private fun hide() {
        // Hide UI first
        fullscreenContentControls?.visibility = View.GONE
        visible = false

        // Schedule a runnable to remove the status and navigation bar after a delay
        hideHandler.removeCallbacks(showPart2Runnable)
        hideHandler.postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY.toLong())
    }

    @Suppress("InlinedApi")
    private fun show() {
        // Show the system bar
        fullscreenContent?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        visible = true

        // Schedule a runnable to display UI elements after a delay
        hideHandler.removeCallbacks(hidePart2Runnable)
        hideHandler.postDelayed(showPart2Runnable, UI_ANIMATION_DELAY.toLong())
        (activity as? AppCompatActivity)?.supportActionBar?.show()
    }

    /**
     * Schedules a call to hide() in [delayMillis], canceling any
     * previously scheduled calls.
     */
    private fun delayedHide(delayMillis: Int) {
        hideHandler.removeCallbacks(hideRunnable)
        hideHandler.postDelayed(hideRunnable, delayMillis.toLong())
    }

    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private const val UI_ANIMATION_DELAY = 300
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
        */
}


