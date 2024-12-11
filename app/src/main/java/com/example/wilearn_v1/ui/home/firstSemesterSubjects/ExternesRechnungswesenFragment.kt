package com.example.wilearn_v1.ui.home.firstSemesterSubjects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wilearn_v1.databinding.FragmentExternesRechnungswesenBinding

class ExternesRechnungswesenFragment : Fragment() {

    private var _binding: FragmentExternesRechnungswesenBinding? = null
    private val binding get() = _binding!!
    private var currentQuestionIndex = 0

    // 💡 Liste mit 10 Quizfragen und Antworten zum Thema Externes Rechnungswesen
    private val questions = listOf(
        Question(
            "Welche der folgenden Aussagen beschreibt den Begriff 'Bilanz' am besten?",
            "Eine Gegenüberstellung von Vermögen und Schulden",
            listOf("Ein Dokument zur Steuerschätzung", "Ein internes Berichtsformular", "Eine Gewinn- und Verlustrechnung")
        ),
        Question(
            "Was versteht man unter 'Aktiva' in einer Bilanz?",
            "Die Vermögenswerte eines Unternehmens",
            listOf("Die Schulden eines Unternehmens", "Die Einnahmen eines Unternehmens", "Die Ausgaben eines Unternehmens")
        ),
        Question(
            "Was ist der Zweck einer Gewinn- und Verlustrechnung (GuV)?",
            "Die Ermittlung des Unternehmenserfolgs in einer Periode",
            listOf("Die Bestimmung des Eigenkapitals", "Die Berechnung der Steuern", "Die Aufstellung des Cashflows")
        ),
        Question(
            "Welche Position gehört zu den Passiva in der Bilanz?",
            "Eigenkapital",
            listOf("Maschinen", "Forderungen", "Vorräte")
        ),
        Question(
            "Was bedeutet der Begriff 'Abschreibung' im externen Rechnungswesen?",
            "Der Wertverlust von Anlagevermögen über die Zeit",
            listOf("Eine Erhöhung des Eigenkapitals", "Eine Zahlung an Lieferanten", "Eine Erhöhung der Verbindlichkeiten")
        ),
        Question(
            "Welche der folgenden Positionen gehört NICHT zum Anlagevermögen?",
            "Vorräte",
            listOf("Maschinen", "Immaterielle Vermögenswerte", "Gebäude")
        ),
        Question(
            "Was beschreibt der Begriff 'Umlaufvermögen'?",
            "Vermögenswerte, die kurzfristig in Geld umgewandelt werden",
            listOf("Langfristige Investitionen", "Eigenkapital", "Verbindlichkeiten gegenüber Lieferanten")
        ),
        Question(
            "Welche der folgenden Aussagen beschreibt den Begriff 'Forderung' am besten?",
            "Ein Anspruch des Unternehmens gegenüber einem Kunden",
            listOf("Ein Zahlungsversprechen an einen Lieferanten", "Eine langfristige Investition", "Ein Verlust in der Gewinn- und Verlustrechnung")
        ),
        Question(
            "Was bedeutet 'Buchführungspflicht' im externen Rechnungswesen?",
            "Die gesetzliche Verpflichtung, Bücher zu führen und Abschlüsse zu erstellen",
            listOf("Das Recht, keine Steuern zu zahlen", "Die Verpflichtung, interne Berichte zu erstellen", "Die Pflicht, den Kontostand zu überwachen")
        ),
        Question(
            "Welche der folgenden Methoden wird häufig zur Berechnung der Abschreibung verwendet?",
            "Lineare Abschreibung",
            listOf("Kumulierte Rückstellung", "Abzinsung", "Zinseszinsmethode")
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExternesRechnungswesenBinding.inflate(inflater, container, false)

        // 🎉 Zeige die erste Frage
        displayQuestion(questions[currentQuestionIndex])

        return binding.root
    }

    // 💡 Funktion, die eine Frage und die Antwortoptionen anzeigt
    private fun displayQuestion(question: Question) {
        binding.questionTextView.text = question.questionText
        val allAnswers = (question.incorrectAnswers + question.correctAnswer).shuffled()

        // Setze die Texte für die Buttons
        binding.button1.text = allAnswers[0]
        binding.button2.text = allAnswers[1]
        binding.button3.text = allAnswers[2]
        binding.button4.text = allAnswers[3]

        // Setze die Aktionen, wenn der Benutzer auf die Buttons klickt
        binding.button1.setOnClickListener { checkAnswer(allAnswers[0]) }
        binding.button2.setOnClickListener { checkAnswer(allAnswers[1]) }
        binding.button3.setOnClickListener { checkAnswer(allAnswers[2]) }
        binding.button4.setOnClickListener { checkAnswer(allAnswers[3]) }
    }

    // 💡 Funktion, die überprüft, ob die Antwort korrekt ist
    private fun checkAnswer(selectedAnswer: String) {
        val currentQuestion = questions[currentQuestionIndex]

        if (selectedAnswer == currentQuestion.correctAnswer) {
            Toast.makeText(requireContext(), "Richtig!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Falsch! Die richtige Antwort ist: ${currentQuestion.correctAnswer}", Toast.LENGTH_LONG).show()
        }

        // Gehe zur nächsten Frage
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            displayQuestion(questions[currentQuestionIndex])
        } else {
            Toast.makeText(requireContext(), "Quiz beendet! Du hast alle Fragen beantwortet.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// 💡 Datenmodell für eine Frage
data class Question(
    val questionText: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
)
