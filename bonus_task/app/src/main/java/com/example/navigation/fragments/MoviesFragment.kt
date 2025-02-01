package com.example.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.adapters.MovieAdapter
import com.example.navigation.models.Movie  // Импорт модели Movie

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Пример данных
        val movieList = listOf(
            Movie("Movie 1", "Description 1"),
            Movie("Movie 2", "Description 2"),
            Movie("Movie 3", "Description 3")
        )

        movieAdapter = MovieAdapter(movieList)  // Передаем список фильмов в адаптер
        recyclerView.adapter = movieAdapter
    }
}
