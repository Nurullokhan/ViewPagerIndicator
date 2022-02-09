package uz.nurulloxon.viewpagerhomework.Models

class ViewData {

    var title: String? = null
    var text: String? = null
    var backImage: Int? = null

    constructor(title: String?, text: String?, backImage: Int?) {
        this.title = title
        this.text = text
        this.backImage = backImage
    }
}