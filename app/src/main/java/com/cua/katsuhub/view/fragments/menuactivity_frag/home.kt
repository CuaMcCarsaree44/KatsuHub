package com.cua.katsuhub.view.fragments.menuactivity_frag


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R
import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Button
import android.widget.ImageButton
import com.cua.katsuhub.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Home : Fragment() {
    private lateinit var mainMenu: Button
    private lateinit var searchAnime: Button
    private lateinit var searchCharacter: Button
    private lateinit var settingTile: ImageButton
    private lateinit var shareTile:ImageButton
    private lateinit var incognitoTile:ImageButton
    private lateinit var reviewTile:ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val v:View = inflater.inflate(com.cua.katsuhub.R.layout.fragment_home, container, false)
        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val binding:FragmentHomeBinding =
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
