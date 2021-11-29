package com.raywenderlich.android.droidquiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.android.droidquiz.data.QuestionInfoProvider
import com.raywenderlich.android.droidquiz.data.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuizRepository) : ViewModel() {

    fun prepopulateQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            for (question in QuestionInfoProvider.questionList) {
                repository.saveQuestion(question)
            }
            for (answer in QuestionInfoProvider.answerList) {
                repository.saveAnswer(answer)
            }
        }
    }

    fun clearQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteQuestions()
        }
    }

}
