package com.raywenderlich.android.droidquiz.data

import com.raywenderlich.android.droidquiz.QuizApplication
import com.raywenderlich.android.droidquiz.data.db.QuizDao
import com.raywenderlich.android.droidquiz.data.model.Answer
import com.raywenderlich.android.droidquiz.data.model.Question

class Repository : QuizRepository {
    private val quizDao: QuizDao by lazy {
        QuizApplication.database.quizDao()
    }
    private val allQuestions by lazy {
        quizDao.getAllQuestions_Live()
    }
    private val allQuestionsAndAllAnswers by lazy {
        quizDao.getQuestionAndAllAnswers_Live()
    }

    override fun getSavedQuestions() = allQuestions

    override suspend fun saveQuestion(question: Question) {
        quizDao.insert(question)
    }

    override suspend fun saveAnswer(answer: Answer) {
        quizDao.insert(answer)
    }

    override fun getQuestionAndAllAnswers() = allQuestionsAndAllAnswers

    override suspend fun deleteQuestions() {
        quizDao.clearQuestions()
    }
}
