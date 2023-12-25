import java.io.Console
import kotlin.math.log2
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.measureTime

fun IntArray.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // сохраняем значение первого элемента во временную переменную
    this[index1] = this[index2] // записываем значение второго элемента в первый
    this[index2] = tmp // записываем значение временной переменной во второй элемент
}

fun timeCalculation() {
    do {
        println("Выберете алгоритм, который хотели бы проверить")
        println("1. Сортировка выбором\n2. Сортировка вставкой\n3. Сортировка пузырьком" +
                "\n4. Сортировка слиянием\n5. Быстрая сортировка\n6. Сортировка Шелла" +
                "\n7. Пирамидная сортировка\n8. TimSort\n9. IntroSort" +
                "\n10. Сортировка Шелла2\n11. Сортировка Шелла3\n0. Выход")
        val choice = readln().toInt()

        when (choice) {
            1 -> {
                var size = 10000
                for (i in 1..10) {
                    val sortedArray = IntArray(size) { it + 1 }
                    val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                    val reverseSortedArray = IntArray(size) { size - it }
                    val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                    val timeSpentSelectionSorted = measureTime {
                        selectionSort(sortedArray)
                    }
                    val timeSpentSelectionAlmostSorted = measureTime {
                        selectionSort(almostSortedArray)
                    }
                    val timeSpentSelectionReverseSorted = measureTime {
                        selectionSort(reverseSortedArray)
                    }
                    val timeSpentSelectionUnknown = measureTime {
                        selectionSort(unknownArray)
                    }

                    println("\nСортировка выбором $i:")
                    println("\n${sortedArray.size}:")
                    println("\n\tОтсортированный массив: $timeSpentSelectionSorted")
                    println("\tПочти отсортированный массив: $timeSpentSelectionAlmostSorted")
                    println("\tОбратно отсортированный массив: $timeSpentSelectionReverseSorted")
                    println("\tНеизвестный массив: $timeSpentSelectionUnknown\n")
                    size += 10000
                }
            }

            2 -> {
                var size = 10000
                for (i in 1..10) {


                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    var timeSpentInsertionSorted: Duration = 0.milliseconds
                    var timeSpentInsertionAlmostSorted: Duration = 0.milliseconds
                    var timeSpentInsertionReverseSorted: Duration = 0.milliseconds
                    var timeSpentInsertionUnknown: Duration = 0.milliseconds

                    for (j in 1..10) {
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        timeSpentInsertionSorted += measureTime {
                            insertionSort(sortedArray)
                        }
                        timeSpentInsertionAlmostSorted += measureTime {
                            insertionSort(almostSortedArray)
                        }
                        timeSpentInsertionReverseSorted += measureTime {
                            insertionSort(reverseSortedArray)
                        }
                        timeSpentInsertionUnknown += measureTime {
                            insertionSort(unknownArray)
                        }
                    }

                    println("\nСортировка вставкой $i:")
                    println("\n\tОтсортированный массив: ${timeSpentInsertionSorted/10}")
                    println("\tПочти отсортированный массив: ${timeSpentInsertionAlmostSorted/10}")
                    println("\tОбратно отсортированный массив: ${timeSpentInsertionReverseSorted/10}")
                    println("\tНеизвестный массив: ${timeSpentInsertionUnknown/10}")



                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }
            }
            3 -> {
                var size = 10000
                for (i in 1..10) {
                    val sortedArray = IntArray(size) { it + 1 }
                    val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                    val reverseSortedArray = IntArray(size) { size - it }
                    val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                    val timeSpentBubbleSorted = measureTime {
                        bubbleSort(sortedArray)
                    }
                    val timeSpentBubbleAlmostSorted = measureTime {
                        bubbleSort(almostSortedArray)
                    }
                    val timeSpentBubbleReverseSorted = measureTime {
                        bubbleSort(reverseSortedArray)
                    }
                    val timeSpentBubbleUnknown = measureTime {
                        bubbleSort(unknownArray)
                    }

                    println("\nСортировка пузырьком $i:")
                    println("\n\tОтсортированный массив: $timeSpentBubbleSorted")
                    println("\tПочти отсортированный массив: $timeSpentBubbleAlmostSorted")
                    println("\tОбратно отсортированный массив: $timeSpentBubbleReverseSorted")
                    println("\tНеизвестный массив: $timeSpentBubbleUnknown")
                    size += 10000
                }


                /*println("\n${sortedArray.contentToString()}")
                println("\n${almostSortedArray.contentToString()}")
                println("\n${reverseSortedArray.contentToString()}")
                println("\n${unknownArray.contentToString()}")*/
            }
            4 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentMergeSorted: Duration = 0.milliseconds
                    var timeSpentMergeAlmostSorted: Duration = 0.milliseconds
                    var timeSpentMergeReverseSorted: Duration = 0.milliseconds
                    var timeSpentMergeUnknown: Duration = 0.milliseconds

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/

                    for (j in 1..100) {
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        timeSpentMergeSorted += measureTime {
                            mergeSort(sortedArray, 0, sortedArray.size - 1)
                        }
                        timeSpentMergeAlmostSorted += measureTime {
                            mergeSort(almostSortedArray, 0, sortedArray.size - 1)
                        }
                        timeSpentMergeReverseSorted += measureTime {
                            mergeSort(reverseSortedArray, 0, sortedArray.size - 1)
                        }
                        timeSpentMergeUnknown += measureTime {
                            mergeSort(unknownArray, 0, sortedArray.size - 1)
                        }
                    }

                    println("\nСортировка слиянием $i:")
                    println("\n\tОтсортированный массив: ${timeSpentMergeSorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentMergeAlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentMergeReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentMergeUnknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }

            }
            5 -> {
                var size = 1000
                for (i in 1..10) {
                    var timeSpentQuickSorted: Duration = 0.milliseconds
                    var timeSpentQuickAlmostSorted: Duration = 0.milliseconds
                    var timeSpentQuickReverseSorted: Duration = 0.milliseconds
                    var timeSpentQuickUnknown: Duration = 0.milliseconds

                    for (j in 1..100) {
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size - 1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/

                        timeSpentQuickSorted += measureTime {
                            quickSort(sortedArray, 0, sortedArray.size - 1)
                        }
                        timeSpentQuickAlmostSorted += measureTime {
                            quickSort(almostSortedArray, 0, sortedArray.size - 1)
                        }
                        timeSpentQuickReverseSorted += measureTime {
                            quickSort(reverseSortedArray, 0, sortedArray.size - 1)
                        }
                        timeSpentQuickUnknown += measureTime {
                            quickSort(unknownArray, 0, sortedArray.size - 1)
                        }
                    }

                    println("\nQuick sort $i:")
                    println("\n\tОтсортированный массив: ${timeSpentQuickSorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentQuickAlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentQuickReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentQuickUnknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 1000
                }

            }
            6 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentShellSorted: Duration = 0.milliseconds
                    var timeSpentShellAlmostSorted: Duration = 0.milliseconds
                    var timeSpentShellReverseSorted: Duration = 0.milliseconds
                    var timeSpentShellUnknown: Duration = 0.milliseconds

                    for (j in 1..100) {
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size - 1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        timeSpentShellSorted += measureTime {
                            shellSort(sortedArray)
                        }
                        timeSpentShellAlmostSorted += measureTime {
                            shellSort(almostSortedArray)
                        }
                        timeSpentShellReverseSorted += measureTime {
                            shellSort(reverseSortedArray)
                        }
                        timeSpentShellUnknown += measureTime {
                            shellSort(unknownArray)
                        }
                    }

                    println("\nShell sort $i:")
                    println("\n\tОтсортированный массив: ${timeSpentShellSorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentShellAlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentShellReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentShellUnknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }

            }
            7 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentHeapSorted: Duration = 0.milliseconds
                    var timeSpentHeapAlmostSorted: Duration = 0.milliseconds
                    var timeSpentHeapReverseSorted: Duration = 0.milliseconds
                    var timeSpentHeapUnknown: Duration = 0.milliseconds

                    for (j in 1..100) {
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size - 1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        timeSpentHeapSorted += measureTime {
                            heapSort(sortedArray)
                        }
                        timeSpentHeapAlmostSorted += measureTime {
                            heapSort(almostSortedArray)
                        }
                        timeSpentHeapReverseSorted += measureTime {
                            heapSort(reverseSortedArray)
                        }
                        timeSpentHeapUnknown += measureTime {
                            heapSort(unknownArray)
                        }
                    }

                    println("\nHeap sort $i:")
                    println("\n\tОтсортированный массив: ${timeSpentHeapSorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentHeapAlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentHeapReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentHeapUnknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }

            }
            8 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentTimSorted: Duration = 0.milliseconds
                    var timeSpentTimAlmostSorted: Duration = 0.milliseconds
                    var timeSpentTimReverseSorted: Duration = 0.milliseconds
                    var timeSpentTimUnknown: Duration = 0.milliseconds

                    for (j in 1..10) {
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size - 1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        timeSpentTimSorted += measureTime {
                            sortedArray.timSort()
                        }
                        timeSpentTimAlmostSorted += measureTime {
                            almostSortedArray.timSort()
                        }
                        timeSpentTimReverseSorted += measureTime {
                            reverseSortedArray.timSort()
                        }
                        timeSpentTimUnknown += measureTime {
                            unknownArray.timSort()
                        }
                    }

                    println("\nTim sort $i:")
                    println("\n\tОтсортированный массив: ${timeSpentTimSorted/10}")
                    println("\tПочти отсортированный массив: ${timeSpentTimAlmostSorted/10}")
                    println("\tОбратно отсортированный массив: ${timeSpentTimReverseSorted/10}")
                    println("\tНеизвестный массив: ${timeSpentTimUnknown/10}")

                    size += 10000
                }

            }
            9 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentIntroSorted: Duration = 0.milliseconds
                    var timeSpentIntroAlmostSorted: Duration = 0.milliseconds
                    var timeSpentIntroReverseSorted: Duration = 0.milliseconds
                    var timeSpentIntroUnknown: Duration = 0.milliseconds

                    for (j in 1..100){
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        /*println("\n${sortedArray.contentToString()}")
                        println("\n${almostSortedArray.contentToString()}")
                        println("\n${reverseSortedArray.contentToString()}")
                        println("\n${unknownArray.contentToString()}")*/

                        timeSpentIntroSorted += measureTime {
                            introSort(sortedArray, 0, size-1, (2 * log2(sortedArray.size.toDouble())).toInt())
                        }
                       timeSpentIntroAlmostSorted += measureTime {
                            introSort(almostSortedArray, 0, size-1, (2 * log2(almostSortedArray.size.toDouble())).toInt())
                        }
                        timeSpentIntroReverseSorted += measureTime {
                            introSort(reverseSortedArray, 0, size-1, (2 * log2(reverseSortedArray.size.toDouble())).toInt())
                        }
                        timeSpentIntroUnknown += measureTime {
                            introSort(unknownArray, 0, size-1, (2 * log2(unknownArray.size.toDouble())).toInt())
                        }
                    }

                    println("\nIntro sort $i:")
                    println("\n\tОтсортированный массив: ${timeSpentIntroSorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentIntroAlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentIntroReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentIntroUnknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }

            }
            10 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentShell2Sorted: Duration = 0.milliseconds
                    var timeSpentShell2AlmostSorted: Duration = 0.milliseconds
                    var timeSpentShell2ReverseSorted: Duration = 0.milliseconds
                    var timeSpentShell2Unknown: Duration = 0.milliseconds

                    for (j in 1..100){
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        /*println("\n${sortedArray.contentToString()}")
                        println("\n${almostSortedArray.contentToString()}")
                        println("\n${reverseSortedArray.contentToString()}")
                        println("\n${unknownArray.contentToString()}")*/

                        timeSpentShell2Sorted += measureTime {
                            shellSort2(sortedArray)
                        }
                        timeSpentShell2AlmostSorted += measureTime {
                            shellSort2(almostSortedArray)
                        }
                        timeSpentShell2ReverseSorted += measureTime {
                            shellSort2(reverseSortedArray)
                        }
                        timeSpentShell2Unknown += measureTime {
                            shellSort2(unknownArray)
                        }
                    }

                    println("\nShell sort2 $i:")
                    println("\n\tОтсортированный массив: ${timeSpentShell2Sorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentShell2AlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentShell2ReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentShell2Unknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }
            }
            11 -> {
                var size = 10000
                for (i in 1..10) {
                    var timeSpentShell3Sorted: Duration = 0.milliseconds
                    var timeSpentShell3AlmostSorted: Duration = 0.milliseconds
                    var timeSpentShell3ReverseSorted: Duration = 0.milliseconds
                    var timeSpentShell3Unknown: Duration = 0.milliseconds

                    for (j in 1..100){
                        val sortedArray = IntArray(size) { it + 1 }
                        val almostSortedArray = IntArray(size) { it + 1 }.apply { swap(0, size-1) }
                        val reverseSortedArray = IntArray(size) { size - it }
                        val unknownArray = IntArray(size) { it + 1 }.apply { shuffle() }

                        /*println("\n${sortedArray.contentToString()}")
                        println("\n${almostSortedArray.contentToString()}")
                        println("\n${reverseSortedArray.contentToString()}")
                        println("\n${unknownArray.contentToString()}")*/

                        timeSpentShell3Sorted += measureTime {
                            shellSort3(sortedArray)
                        }
                        timeSpentShell3AlmostSorted += measureTime {
                            shellSort3(almostSortedArray)
                        }
                        timeSpentShell3ReverseSorted += measureTime {
                            shellSort3(reverseSortedArray)
                        }
                        timeSpentShell3Unknown += measureTime {
                            shellSort3(unknownArray)
                        }
                    }

                    println("\nShell sort3 $i:")
                    println("\n\tОтсортированный массив: ${timeSpentShell3Sorted/100}")
                    println("\tПочти отсортированный массив: ${timeSpentShell3AlmostSorted/100}")
                    println("\tОбратно отсортированный массив: ${timeSpentShell3ReverseSorted/100}")
                    println("\tНеизвестный массив: ${timeSpentShell3Unknown/100}")

                    /*println("\n${sortedArray.contentToString()}")
                    println("\n${almostSortedArray.contentToString()}")
                    println("\n${reverseSortedArray.contentToString()}")
                    println("\n${unknownArray.contentToString()}")*/
                    size += 10000
                }
            }
        }
        println()
    }while (choice != 0)
}