package com.raywenderlich.android.droidquiz.data.db

import androidx.room.*
import com.raywenderlich.android.droidquiz.data.model.Answer
import com.raywenderlich.android.droidquiz.data.model.Question
import com.raywenderlich.android.droidquiz.data.model.QuestionAndAllAnswers

@Dao
interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(answer: Answer)

    @Query("DELETE FROM question")
    fun clearQuestions()

    @Delete
    fun deleteQuestion(question: Question)

    @Query("SELECT * FROM question ORDER BY question_id")
    fun getAllQuestions(): List<Question>

    /*
    @Transaction tells Room that the following SQL statements should be executed in a single transaction.
    This is especially useful when you want to query multiple tables like in the case of your one-to-many relation between the questions table and the answers table.
    * */
    @Transaction
    /*
    Finally, you’re creating a select statement to retrieve all the questions from your questions table.
    Notice that this method is returning a list of your QuestionAndAllAnswers class so Room will immediately take the answers associated with each question and store them inside the properties of your class.
    * */
    @Query("SELECT * FROM question")
    fun getQuestionAndAllAnswers(): List<QuestionAndAllAnswers>

}
