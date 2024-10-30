package com.example.studentattendance; // Change this to your actual package name

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.studentattendance.databinding.FragmentFirstBinding; // Ensure this import is correct

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding; // Declare binding variable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout using View Binding
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        // Get the root view of the binding
        View view = binding.buttonFirst.getRootView();

        // Set the click listener for the button
        binding.buttonFirst.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
        });

        return view; // Return the root view
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Clear binding reference to prevent memory leaks
    }
}
