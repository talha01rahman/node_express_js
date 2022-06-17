// Changing _id key to id - more frontend friendly

productSchema.virtual('id').get(function () {
    return this._id.toHexString();
});
