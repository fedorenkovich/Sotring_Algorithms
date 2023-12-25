import java.lang.Math.pow
import kotlin.math.min

fun selectionSort(array: IntArray) {
    val n = array.size
    for (i in 0..<n - 1) {
        var minIndex = i
        for (j in i + 1..<n) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        val temp = array[minIndex]
        array[minIndex] = array[i]
        array[i] = temp
    }
}

fun insertionSort(array: IntArray) {
    for (i in 1..<array.size) {
        val key = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = key
    }
}

fun bubbleSort(array: IntArray) {
    val n = array.size
    for (i in 0..<n) {
        for (j in 0..<n - i - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

fun mergeSort(array: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(array, left, mid)
        mergeSort(array, mid + 1, right)
        merge(array, left, mid, right)
    }
}

fun merge(array: IntArray, left: Int, mid: Int, right: Int) {
    val n1 = mid - left + 1
    val n2 = right - mid
    val leftArray = IntArray(n1)
    val rightArray = IntArray(n2)
    for (i in 0..<n1) {
        leftArray[i] = array[left + i]
    }
    for (j in 0..<n2) {
        rightArray[j] = array[mid + 1 + j]
    }
    var i = 0
    var j = 0
    var k = left
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i]
            i++
        } else {
            array[k] = rightArray[j]
            j++
        }
        k++
    }
    while (i < n1) {
        array[k] = leftArray[i]
        i++
        k++
    }
    while (j < n2) {
        array[k] = rightArray[j]
        j++
        k++
    }
}

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if(low < high) {
        val pivot: Int = partition(arr, low, high)
        quickSort(arr, low, pivot)
        quickSort(arr, pivot + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {

    val pivot = arr[low]
    var i: Int = low
    var j: Int = high

    while(i < j) {
        while(arr[i] <= pivot && i < high) {
            i++
        }

        while(arr[j] > pivot && j > low) {
            j--
        }

        if(i < j) {
            val temp: Int = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    arr[low] = arr[j]
    arr[j] = pivot

    return j
}

fun shellSort(arr: IntArray) {
    val arraySize = arr.size
    var gap = arraySize / 2
    while (gap > 0) {
        var i = gap
        while (i < arraySize) {
            val temp = arr[i]
            var j = i
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap]
                j -= gap
            }
            arr[j] = temp
            i += 1
        }
        gap /= 2
    }
}

fun deg(length: Int, dig: Int): Int {
    var i = 0
    var k = 1
    while (length > k) {
        k *= dig
        i++
    }
    return i
}

fun shellSort2(arr: IntArray) {
    val arraySize = arr.size
    val k = deg(arr.size, 2)
    var gap = (Math.pow(2.0, k.toDouble()).toInt() - 1).toInt()
    while (gap > 0) {
        var i = gap
        while (i < arraySize) {
            val temp = arr[i]
            var j = i
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap]
                j -= gap
            }
            arr[j] = temp
            i += 1
        }
        gap /= 2
    }
}



fun shellSort3(arr: IntArray) {
    val arraySize = arr.size
    val k = deg(arr.size, 2)
    var gap = (Math.pow(3.0, k.toDouble()).toInt() - 1).toInt() / 2
    while (gap > 0) {
        var i = gap
        while (i < arraySize) {
            val temp = arr[i]
            var j = i
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap]
                j -= gap
            }
            arr[j] = temp
            i += 1
        }
        gap /= 3
    }
}


fun heapSort(arr: IntArray) {
    val n = arr.size

    for (i in n / 2 - 1 downTo 0)
        heapify(arr, n, i)

    for (i in n - 1 downTo 0) {
        val temp = arr[0]
        arr[0] = arr[i]
        arr[i] = temp

        heapify(arr, i, 0)
    }
}

fun heapify(arr: IntArray, n: Int, i: Int) {
    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left < n && arr[left] > arr[largest])
        largest = left

    if (right < n && arr[right] > arr[largest])
        largest = right

    if (largest != i) {
        val swap = arr[i]
        arr[i] = arr[largest]
        arr[largest] = swap

        heapify(arr, n, largest)
    }
}

fun IntArray.timSort() {
    val size = size
    val minrun = minrunForTim(size)
    var index = 0
    while (index < size) {
        insertionSortForTim(this, index, min(index + minrun - 1, size - 1))
        index += minrun
    }

    var mergingSize = minrun
    while (mergingSize < size) {

        var left = 0
        while (left < size) {
            val middle = left + mergingSize - 1
            val right = min(left + 2 * mergingSize - 1, size - 1)
            if (middle < right) {
                mergeForTim(this, left, middle, right)
            }
            left += mergingSize * 2
        }

        mergingSize *= 2
    }
}

private fun minrunForTim(n: Int) : Int {
    var addedValue = 0
    var size = n
    if (size >= 64) {
        addedValue = addedValue or (size and 1)
        size = size.shr(1)
    }
    return size + addedValue
}

private fun insertionSortForTim(array: IntArray, left: Int, right: Int) {
    var outerIndex = left + 1
    while (outerIndex <= right) {
        val temporaryValue = array[outerIndex]
        var innerIndex = outerIndex - 1
        while (innerIndex >= left && array[innerIndex] > temporaryValue) {
            array[innerIndex + 1] = array[innerIndex]
            innerIndex--
        }
        array[innerIndex + 1] = temporaryValue
        outerIndex++
    }
}

private fun mergeForTim(array: IntArray, left: Int, middle: Int, right: Int) {
    val leftLengthArray = middle - left + 1
    val rightLengthArray = right - middle

    var index = 0
    val leftArray = Array(leftLengthArray) { 0 }
    while (index < leftLengthArray) {
        leftArray[index] = array[left + index]
        index++
    }

    index = 0
    val rightArray = Array(rightLengthArray) { 0 }
    while (index < rightLengthArray) {
        rightArray[index] = array[middle + 1 + index]
        index++
    }

    var leftArrayIndex = 0
    var rightArrayIndex = 0
    index = 0

    while (leftArrayIndex < leftLengthArray && rightArrayIndex < rightLengthArray) {
        if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
            array[index] = leftArray[leftArrayIndex]
            leftArrayIndex++
        } else {
            array[index] = rightArray[rightArrayIndex]
            rightArrayIndex++
        }
        index++
    }

    while (leftArrayIndex < leftLengthArray) {
        array[index] = leftArray[leftArrayIndex]
        leftArrayIndex++
        index++
    }

    while (rightArrayIndex < rightLengthArray) {
        array[index] = rightArray[rightArrayIndex]
        rightArrayIndex++
        index++
    }
}

fun introSort(arr: IntArray, begin: Int, end: Int, maxdepth: Int) {
    if ((end - begin) < 16) {
        insertionSortForIntro(arr, begin, end)
    } else if (maxdepth == 0) {
        heapSortForIntro(arr, end, begin)
    } else {
        val pivot = pivotPartitionForIntro(arr, begin, end)
        introSort(arr, begin, pivot, maxdepth - 1)
        introSort(arr, pivot + 1, end, maxdepth - 1)
    }
}

fun heapSortForIntro(arr: IntArray, end: Int, begin: Int) {
    for (i in (end - begin) / 2 - 1 downTo 0) {
        heapifyForIntro(arr, end - begin, i)
    }
    for (i in (end - begin) - 1 downTo 0) {
        val temp = arr[0]
        arr[0] = arr[i]
        arr[i] = temp
        heapifyForIntro(arr, i, 0)
    }
}

fun heapifyForIntro(arr: IntArray, length: Int, i: Int) {
    var maxElem = i
    val left = 2 * i + 1
    val right = 2 * i + 2
    if (left < length && arr[left] > arr[maxElem]) {
        maxElem = left
    }
    if (right < length && arr[right] > arr[maxElem]) {
        maxElem = right
    }
    if (maxElem != i) {
        val tmp = arr[i]
        arr[i] = arr[maxElem]
        arr[maxElem] = tmp
        heapify(arr, length, maxElem)
    }
}

fun insertionSortForIntro(arr: IntArray, left: Int, right: Int) {
    for (j in left..right) {
        val keyNum = arr[j]
        var i = j - 1
        while (i >= left && arr[i] > keyNum) {
            arr[i + 1] = arr[i]
            i--
        }
        arr[i + 1] = keyNum
    }
}

fun pivotPartitionForIntro(arr: IntArray, begin: Int, end: Int): Int {
    val pivot = arr[begin] + arr[end] + arr[(end - begin) / 2] - maxOf(arr[begin], arr[end], arr[(end - begin) / 2]) - minOf(arr[begin], arr[end], arr[(end - begin) / 2])
    if (arr[begin] == pivot) {
        val temp = arr[begin]
        arr[begin] = arr[end]
        arr[end] = temp
    } else if (arr[(end - begin) / 2] == pivot) {
        val temp = arr[(end - begin) / 2]
        arr[(end - begin) / 2] = arr[end]
        arr[end] = temp
    }
    return partitionForIntro(arr, begin, end)
}

fun partitionForIntro(arr: IntArray, begin: Int, end: Int): Int {
    val pivot = arr[end]
    var index = begin

    for (i in begin..<end) {
        if (arr[i] <= pivot) {
            val temp = arr[i]
            arr[i] = arr[index]
            arr[index] = temp
            index++
        }
    }
    val temp = arr[end]
    arr[end] = arr[index]
    arr[index] = temp
    return index
}

fun main() {
    timeCalculation()
}