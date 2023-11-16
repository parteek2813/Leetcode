var TimeLimitedCache = function () {
    this.map = {}
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
    let exists = false

    if (key in this.map) {
        exists = true
        clearTimeout(this.map[key].idTimeout)
    }

    this.map[key] = {
        value,
        access: true,
        idTimeout: setTimeout(() => {
            this.map[key].access = false
        }, duration)
    }

    return exists
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function (key) {
    if (key in this.map && this.map[key].access) {
        return this.map[key].value
    }

    return -1
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function () {
    return Object.values(this.map).filter(item => item.access).length
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */